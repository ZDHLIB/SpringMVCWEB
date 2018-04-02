package ca.csi5112.Controller;

import ca.csi5112.Enums.AppointStateEnum;
import ca.csi5112.Dto.AppointExecution;
import ca.csi5112.Dto.ResponseContext;
import ca.csi5112.Entity.Book;
import ca.csi5112.Exceptions.NoNumberException;
import ca.csi5112.Exceptions.RepeatAppointException;
import ca.csi5112.Service.IBookService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String getAllBooks(Model model){
        List<Book> list = bookService.getAllBooks();
        model.addAttribute("list", list);
        System.out.println(list.get(0).getBookId());
        return "list";
    }

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String getBookDetails(@PathVariable("bookId") String bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        System.out.println(book.getBookId());
        return "detail";
    }

    @RequestMapping(value = "/appoint", method = RequestMethod.POST, produces = {"application/form-data"})
//    @ResponseBody
    private String appoint(@RequestParam("bookId") String bookId,
                                             @RequestParam("studentId") String studentId) {
//    private ResponseContext<AppointExecution> appoint(@RequestBody String body) {
//        System.out.println(body);
//        JSONObject jo = JSON.parseObject(body);
//        String studentId = jo.getString("studentId");
//        String bookId = jo.getString("bookId");
        if (studentId == null || studentId.equals("")) {
//            return new ResponseContext<>(false, "Student No. is None.");
            return "error";
        }

        AppointExecution execution = null;
        try {
            execution = bookService.makeAppointment(bookId, studentId);
            System.out.println(execution.getBookStateInfo());
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return "index";
    }


}
