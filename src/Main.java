
import dao.BootcampDao;
import dao.CursoDao;
import dao.DevDao;
import dao.MentoriaDao;

import service.BootcampService;
import service.CursoService;
import service.DataLoaderService;
import service.DevService;
import service.MentoriaService;

public class Main {

    public static void main(String[] args) {

        CursoDao cursoDao = new CursoDao();
        MentoriaDao mentoriaDao = new MentoriaDao();
        BootcampDao bootcampDao = new BootcampDao();
        DevDao devDao = new DevDao();

        CursoService cursoService = new CursoService(cursoDao);
        MentoriaService mentoriaService = new MentoriaService(mentoriaDao);
        BootcampService bootcampService = new BootcampService(bootcampDao);
        DevService devService = new DevService(devDao);

        DataLoaderService dataLoaderService = new DataLoaderService(cursoService, mentoriaService, bootcampService);
        dataLoaderService.seed();

        printSection("BOOTCAMPS COM CURSO > 40H");
        bootcampService.bootcampsComCursoLongo(40).forEach(System.out::println);

        printSection("BOOTCAMPS COM MENTORIA FUTURA");
        bootcampService.bootcampsComMentoriaFutura().forEach(System.out::println);

        printSection("TOTAIS");
        System.out.println("Cursos: " + cursoService.totalCursos());
        System.out.println("Mentorias: " + mentoriaService.totalMentorias());
        System.out.println("Bootcamps: " + bootcampService.totalBootcamps());
        System.out.println("Devs: " + devService.totalDevs());
    }

    private static void printSection(String title) {
        System.out.println("\n=== " + title + " ===");
    }
}