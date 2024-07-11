package org.schroh.interf.imprenta;

import org.schroh.interf.imprenta.models.Curriculum;
import org.schroh.interf.imprenta.models.Hoja;
import org.schroh.interf.imprenta.models.Informe;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Santiago Schroh", "Tecnico Superior en programacion", "Trabajo de muchas cosas");
        cv.addExperiencia("Java")
                .addExperiencia("JavaScript")
                .addExperiencia("React")
                .addExperiencia("SQL")
                .addExperiencia("Python");
        
        Informe informe = new Informe("Realizo Bootcamps y Estudio en la Universidad Nacional Tecnologica", "Juan Mendez", "378");
        imprimir(cv);
        imprimir(informe);
    }

    public static void imprimir(Hoja imprimible) {
        System.out.println(imprimible.imprimir());
    
    }
}
