package com.example.quiz2.Controller;

import com.example.quiz2.ApiResponse.ApiResponse;
import com.example.quiz2.Model.Book;
import com.example.quiz2.Model.User;
import com.example.quiz2.Service.ServiceLibrary;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/library-system")
public class ControllerLibrary {

    private final ServiceLibrary serviceLibrary;

    @GetMapping("/book/get")
    public ResponseEntity<?> getBook(){
        ArrayList book = serviceLibrary.getBook();
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/user/get")
    public ResponseEntity<?> getUser(){
        ArrayList user = serviceLibrary.getUser();
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/book/add")
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        serviceLibrary.addBook(book);
        return ResponseEntity.status(200).body("book added");
    }

    @PostMapping("/user/add")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        serviceLibrary.addUser(user);
        return ResponseEntity.status(200).body("added user");
    }


    @PutMapping("/book/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody @Valid Book book, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
       boolean isUpadet= serviceLibrary.updateBook(id,book);
        if (isUpadet){
            return ResponseEntity.status(200).body("updated book");
        }

        return ResponseEntity.status(400).body("id not found");
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id , @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        }

        boolean isUpdate = serviceLibrary.updateUser(id,user);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated user");
        }
        return ResponseEntity.status(400).body("id not found");
    }


    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        boolean deleted= serviceLibrary.deleteBook(id);
        if (deleted){
            return ResponseEntity.status(200).body("book deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        boolean deleted = serviceLibrary.deleteUser(id);
        if (deleted){
            return ResponseEntity.status(200).body("user delete");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    //9
    @GetMapping("/balance/{balance}")
    public ResponseEntity balanceAbove(@PathVariable int balance){
        ArrayList balanceA = serviceLibrary.balanceAbove(balance);
        return ResponseEntity.status(200).body(balanceA);
    }



    //10
    @GetMapping("/age/{num}")
    public ResponseEntity ageAbove(@PathVariable int num){
    ArrayList agesame = serviceLibrary.ageAbove(num);
    return ResponseEntity.status(200).body(agesame);
    }

    //11
    @GetMapping("/search/{namebook}")
    public ResponseEntity searchBookByName(@PathVariable String namebook){
        Book book=serviceLibrary.searchBookByName(namebook);
        if(book==null){
            return ResponseEntity.status(400).body("not found");
        }
        return ResponseEntity.status(200).body(book);
    }

    //12
    @GetMapping("/category/{category}")
    public ResponseEntity sameCategory(@PathVariable String category){
        ArrayList same=serviceLibrary.sameCategory(category);
        return ResponseEntity.status(200).body(category);
    }

    //13
    @GetMapping("/pages/{number}")
    public ResponseEntity samePage(@PathVariable int number){
        ArrayList pages=serviceLibrary.samePage(number);
        return ResponseEntity.status(200).body(pages);
    }
    //14
    @PutMapping("/change-status/{id}/{bookid}")
    public ResponseEntity<?> changeStatus(@PathVariable String id, @PathVariable String bookid){
        boolean isChange=serviceLibrary.changeStatus(id,bookid);
        if (isChange){
            return ResponseEntity.status(200).body("update the status of book");
        }
        return ResponseEntity.status(400).body("id not found");
    }


}

