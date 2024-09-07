/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import org.hibernate.*;
import service.StudentInterface;

/**
 *
 * @author jeremie
 */
public class Server extends UnicastRemoteObject implements StudentInterface{
    public Server() throws RemoteException{
        super();
    }
    
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        try {
            Registry registry = LocateRegistry.createRegistry(7000);
            registry.rebind("client", new Server());
            System.out.println("Server is running on port 7000");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String saveStudent(Student stud) throws RemoteException {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(stud);
        tr.commit();
        ss.close();
        return "Data Saved Successful";
    }

    @Override
    public String updateStudent(Student stud) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteStudent(Student stud) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student findById(Student stud) throws RemoteException {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Student student = (Student)ss.get(Student.class, stud.getStudent_id());
        ss.close();
        return student;
    }

    @Override
    public List<Student> findAll() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
