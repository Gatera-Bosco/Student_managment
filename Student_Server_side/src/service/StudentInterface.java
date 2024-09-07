/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.util.List;
import model.Student;

/**
 *
 * @author jeremie
 */
public interface StudentInterface {
    String saveStudent(Student stud) throws RemoteException;
    String updateStudent(Student stud) throws RemoteException;
    String deleteStudent(Student stud) throws RemoteException;
    Student findById(Student stud) throws  RemoteException;
    List<Student> findAll() throws RemoteException;
}