/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import restful.Clase;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */

public class Restful {
   private static EntityManagerFactory emf;
   private static EntityManager em;
   private static String dato;
    /**
     * @param args the command line arguments
     */
   
//CRUD de Clase 
    public Clase CreateClase(){
        Clase clase = new Clase();
        System.out.println("Ingrese la identificación de la clase");
        Scanner s = new Scanner(System.in);
        clase.setNumeroClase(Integer.parseInt(s.nextLine()));
        System.out.println("Ingrese el nombre de la clase");
        clase.setNombreClase(s.nextLine());
        em.persist(clase);
        return clase;
    }    
    
    
    public Clase UpdateClase(){
        Clase clase = new Clase();
        System.out.println("Ingrese la identificación de la clase");
        Scanner s = new Scanner(System.in);
        clase.setNumeroClase(Integer.parseInt(s.nextLine()));
        System.out.println("Ingrese el nombre de la clase");
        clase.setNombreClase(s.nextLine());
        return clase;
    } 
    
    public Clase ReadClase(){
        Clase clase = new Clase();
        System.out.println("Ingrese la identificación de la clase");
        Scanner s = new Scanner(System.in);
        clase.setNumeroClase(Integer.parseInt(s.nextLine()));
        clase = em.find(Clase.class, clase.getNumeroClase());
        return clase;
    }
    
    public Clase DeleteClase(){
        Clase clase = new Clase();
        System.out.println("Ingrese la identificación de la clase");
        Scanner s = new Scanner(System.in);
        clase.setNumeroClase(Integer.parseInt(s.nextLine()));
        clase = em.find(Clase.class, clase.getNumeroClase());
        return clase;
    }
//fin CRUD Clase

//CRUD de Maestro
    public Maestro CreateMaestro(){
        Maestro maestro = new Maestro();
        System.out.println("Ingrese el codigo del maestro");
        Scanner s = new Scanner(System.in);
        maestro.setNumeroMaestro(Integer.parseInt(s.nextLine()));
        System.out.println("Ingrese el nombre del maestro");
        maestro.setNombreMaestro(s.nextLine());
        return maestro;
    }
    
    public Maestro ReadMaestro(){
        Maestro maestro = new Maestro();
        System.out.println("Ingrese el codigo del maestro");
        Scanner s = new Scanner(System.in);
        maestro.setNumeroMaestro(Integer.parseInt(s.nextLine()));
        maestro = em.find(Maestro.class,maestro.getNumeroMaestro());
        return maestro;
    }
    
    public Maestro UpdateMaestro(){
        Maestro maestro = new Maestro();
        System.out.println("Ingrese el codigo del maestro");
        Scanner s = new Scanner(System.in);
        maestro.setNumeroMaestro(Integer.parseInt(s.nextLine()));
        System.out.println("Ingrese el nombre del maestro");
        maestro.setNombreMaestro(s.nextLine());
        return maestro;
    }
    
    public Maestro DeleteMaestro(){
        Maestro maestro = new Maestro();
        System.out.println("Ingrese el codigo del maestro");
        Scanner s = new Scanner(System.in);
        maestro.setNumeroMaestro(Integer.parseInt(s.nextLine()));
        maestro = em.find(Maestro.class, maestro.getNumeroMaestro());
        return maestro;
    }
    
//fin CRUD Maestro


//CRUD de Estudiante
    public Estudiante CreateEstudiante(){
        Estudiante estudiante = new Estudiante();
        Clase claseAso = new Clase();
        Maestro MaestroAso = new Maestro();
        Scanner s = new Scanner(System.in);
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese el codigo del estudiante");
        estudiante.setId(Integer.parseInt(s.nextLine()));
        System.out.println("Ingrese el nombre del estudiante");
        estudiante.setNombre(s.nextLine());
        System.out.println("Ingrese el apellido del estudiante");
        estudiante.setApellido(s.nextLine());
        System.out.println("Ingrese el codigo de la clase");
        claseAso.setNumeroClase(Integer.parseInt(t.nextLine()));
        claseAso = em.find(Clase.class, claseAso.getNumeroClase());
        estudiante.setClase(claseAso);
        System.out.println("Ingrese el codigo del maestro");
        MaestroAso.setNumeroMaestro(Integer.parseInt(t.nextLine()));
        MaestroAso = em.find(Maestro.class, MaestroAso.getNumeroMaestro());
        estudiante.setProfesor(MaestroAso);
        return estudiante;
    }
    
    public Estudiante ReadEstudiante(){
        Estudiante estudiante = new Estudiante();
        Clase claseAso = new Clase();
        Maestro MaestroAso = new Maestro();
        Scanner v = new Scanner(System.in);
        System.out.println("Ingrese el codigo del estudiante");
        estudiante.setId(Integer.parseInt(v.nextLine()));
        estudiante.setClase(claseAso);
        estudiante.setProfesor(MaestroAso);
        estudiante = em.find(Estudiante.class,estudiante.getId());
        return estudiante;
    }
    
    public Estudiante UpdateEstudiante(){
        Estudiante estudiante = new Estudiante();
        Clase claseAso = new Clase();
        Maestro maestroAso = new Maestro();
        Scanner v = new Scanner(System.in);
        System.out.println("Ingrese el ID de estudiante");
        estudiante.setId(Integer.parseInt(v.nextLine()));
        System.out.println("Ingrese el nombre del estudiante");
        estudiante.setNombre(v.nextLine());
        System.out.println("Ingrese el apellido del estudiante");
        estudiante.setApellido(v.nextLine());
        System.out.println("Ingrese el profesor");
        maestroAso.setNumeroMaestro(Integer.parseInt(v.nextLine()));
        maestroAso = em.find(Maestro.class, maestroAso.getNumeroMaestro());
        estudiante.setProfesor(maestroAso);
        System.out.println("Ingrese la clase");
        claseAso.setNumeroClase(Integer.parseInt(v.nextLine()));
        claseAso = em.find(Clase.class, claseAso.getNumeroClase());
        estudiante.setClase(claseAso);
        estudiante = em.merge(estudiante);
        return estudiante;
    }
    
    public Estudiante DeleteEstudiante(){
        Estudiante estudiante = new Estudiante();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id de estudiante");
        estudiante.setId(Integer.parseInt(s.nextLine()));
        estudiante = em.find(Estudiante.class, estudiante.getId());
        return estudiante;
    }
//fin CRUD Estudiante
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RestfulPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        
        /*
        
        Estudiante estudiante = new Estudiante();
        Clase cl = new Clase();
        Maestro pr = new Maestro();
        estudiante.setId(1234);
        estudiante.setNombre("Leonardo");
        estudiante.setApellido("Ruiz");
        estudiante.setProfesor(pr);
        estudiante.setClase(cl);
        cl.setNumeroClase(123);
        pr.setNumeroMaestro(1);
        
        em.persist(estudiante);
        //em.merge(em);
        */
        
        Restful rest = new Restful();
        System.out.println("ingrese el dato a capturar");
        System.out.println("1.Crear clase");
        System.out.println("2.Buscar clase");
        System.out.println("3.Modificar clase");
        System.out.println("4.Eliminar clase");
        System.out.println("5.Crear maestro");
        System.out.println("6.Buscar maestro");
        System.out.println("7.Modificar maestro");
        System.out.println("8.Eliminar maestro");
        System.out.println("9.Crear estudiante");
        System.out.println("10.Buscar estudiante");
        System.out.println("11.Modificar estudiante");
        System.out.println("12.Eliminar estudiante");
        Scanner s=new Scanner(System.in);
        String captura = s.nextLine();
        System.out.println("Eliga una opcion"+captura);
        
        //System.out.println("Eliga una opcion");
                
        int opcionMenu = s.nextInt();
        
        
        if(opcionMenu == 1){
            //Arbitro arbitro = claseCliente.crearArbitro();
            Clase CreateClass = rest.CreateClase();   
        }else if(opcionMenu == 2){
            Clase ReadClass = rest.ReadClase();
            System.out.println("el nombre de la clase es: " + ReadClass.getNombreClase());
        }else if(opcionMenu == 3){
            Clase UpdateClass = rest.UpdateClase();
            em.merge(UpdateClass);
        }else if(opcionMenu == 4){
            Clase DeleteClass = rest.DeleteClase();
            em.remove(DeleteClass);
        }else if(opcionMenu == 5){
            Maestro CreateTeacher = rest.CreateMaestro();
            em.persist(CreateTeacher);
        }else if(opcionMenu == 6){
            Maestro ReadTeacher = rest.ReadMaestro();
            System.out.println("el nombre de la clase es: " + ReadTeacher.getNombreMaestro());
        }else if(opcionMenu == 7){
            Maestro UpdateTeacher = rest.UpdateMaestro();
            em.merge(UpdateTeacher);
        }else if(opcionMenu == 8){
            Maestro DeleteTeacher = rest.DeleteMaestro();
            em.remove(DeleteTeacher);
        }else if(opcionMenu == 9){
            Estudiante createEstudent = rest.CreateEstudiante();
            em.persist(createEstudent);
        }else if(opcionMenu == 10){
            Estudiante ReadEstudent = rest.ReadEstudiante();
            System.out.println("el nombre de la clase es: " + ReadEstudent.getApellido() + "\n" + "la clase es: " + ReadEstudent.getClase() + "\n" + ReadEstudent.getProfesor());
        }else if(opcionMenu == 11){
            Estudiante UpdateEstudent = rest.UpdateEstudiante();
        }else if(opcionMenu == 12){
            Estudiante DeleteEstudent = rest.DeleteEstudiante();
            em.remove(DeleteEstudent);
        }else{
            System.out.println("Opcion no valida");
        }
        
        
        
        
        em.getTransaction().commit();

        em.close();
        emf.close();
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
