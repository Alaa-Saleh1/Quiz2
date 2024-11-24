package com.example.quiz2.Service;

import ch.qos.logback.core.pattern.FormatInfo;
import com.example.quiz2.Model.Book;
import com.example.quiz2.Model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceLibrary {

    ArrayList<Book> books = new ArrayList();
    ArrayList<User> users = new ArrayList<>();


    public ArrayList getBook(){
        return books;
    }

    public ArrayList getUser(){
        return users;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addUser(User user){
        users.add(user);
    }

    public boolean updateBook(String id,Book book){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equalsIgnoreCase(id)){
                books.set(i,book);
                return true;
            }
        }
        return false;
    }

    public boolean updateUser(String id, User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(id)){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(String id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId().equalsIgnoreCase(id)){
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean deleteUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(id)){
                users.remove(i);
                return true;
            }

        }
        return false;
    }



    //9
    public ArrayList balanceAbove(double balnce){
        ArrayList<User> above=new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getBalance()>=balnce){
                above.add(users.get(i));
            }
        }
        return above;
    }

    //10
    public ArrayList ageAbove(int age){
        ArrayList<User> above=new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAge()>=age){
                above.add(users.get(i));
            }
        }
        return above;
    }
    //11
    public Book searchBookByName(String name){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)){
                return books.get(i);
            }
        }
        return null;
    }

    //12
    public ArrayList sameCategory(String category){
        ArrayList<Book> categorys=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getCategory().equalsIgnoreCase(category)){
                categorys.add(books.get(i));
            }
        }
        return categorys;
    }

    //13
    public ArrayList samePage(int numberPage){
        ArrayList<Book> page=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getNumber_of_pages()>=numberPage){
                page.add(books.get(i));
            }
        }
        return page;
    }

    //14
    public boolean changeStatus(String id, String bookid){
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if (users.get(i).getId().equals(id)&&users.get(i).getRole().equalsIgnoreCase("libraian")){
                    if (books.get(j).getId().equals(bookid)){
                     books.get(j).setAvailable(false);
                     return true;
                    }
                }
            }
        }
        return false;
    }


}



