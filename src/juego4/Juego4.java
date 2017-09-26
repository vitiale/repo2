/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alba Proyecto
 */
public class Juego4 extends JPanel {

    private double x;
    private double y;

    private double encajar = 15;
    private double conversion = 3.14159265 / 180;
    private double rec=5;
    private double espacio_muro=15;

    private double ln;
    private double h;
    private double ld;
    private double angulo;

    private double ca_diag_derecha_sup_x;
    private double co_diag_derecha_sup_y;

//    private double pto_diag_drch_sup_down_y = Math.tan(angulo * conversion) * ((x + ln + encajar + ca_diag_derecha_sup_x) - (x - ca_diag_derecha_sup_x)) + y - co_diag_derecha_sup_y;
//    private double co_diag_derecha_inf_y = (Math.sin(angulo * conversion) * ld);

    public Juego4(double x, double y, double ln, double h, double ld, double angulo) {
        this.x = x;
        this.y = y;
        this.ln = ln;
        this.h = h;
        this.ld = ld;
        this.angulo = angulo;
    }

    public void calculo(Graphics2D g2d) {
        double ca_diag_derecha_sup_x = (Math.cos(angulo * conversion) * ld);
        double co_diag_derecha_sup_y = (Math.sin(angulo * conversion) * ld);

        double pto_diag_drch_sup_down_y = Math.tan(angulo * conversion) * ((x + ln + encajar + ca_diag_derecha_sup_x) - (x - ca_diag_derecha_sup_x)) + y - co_diag_derecha_sup_y;

//       Line2D l1=new Line2D.Double(x, y, x+200, y+200);
//       Line2D l2=new Line2D.Double(x, y+200, x+200, y);
        Line2D l3 = new Line2D.Double(x, y, x + ln, y);
        Line2D l4 = new Line2D.Double(x - encajar, y + rec, x + ln + encajar, y + rec);
        Line2D l5 = new Line2D.Double(x, y + h, x + ln, y + h);
        Line2D l6 = new Line2D.Double(x - encajar, y + h - rec, x + ln + encajar, y + h - rec);
        g2d.setColor(Color.red);
        //diagonal drch sup_up
        Line2D diag_derecha_sup = new Line2D.Double(x + ln, y + rec, x + ln + ca_diag_derecha_sup_x, y + rec - co_diag_derecha_sup_y);
        g2d.draw(diag_derecha_sup);
        //diagonal drch inf_down
        Line2D diag_derecha_inf = new Line2D.Double(x + ln, y + h - rec, x + ln + ca_diag_derecha_sup_x, y + h - rec + co_diag_derecha_sup_y);
        g2d.draw(diag_derecha_inf);
        //diagonal izq sup_up
        Line2D diag_izq_sup = new Line2D.Double(x, y + rec, x - ca_diag_derecha_sup_x, y + rec - co_diag_derecha_sup_y);
        g2d.draw(diag_izq_sup);
        //diagonal izq inf_down
        Line2D diag_izq_inf = new Line2D.Double(x, y + h - rec, x - ca_diag_derecha_sup_x, y + h - rec + co_diag_derecha_sup_y);
        g2d.draw(diag_izq_inf);
        //diagonal completa
        Line2D completa = new Line2D.Double(x - ca_diag_derecha_sup_x, y + rec - co_diag_derecha_sup_y, x + ln + ca_diag_derecha_sup_x, pto_diag_drch_sup_down_y);
        g2d.draw(completa);
//        //diagonal completa1
//        Line2D completa1 = new Line2D.Double(x - ca_diag_derecha_sup_x, y + h - rec + co_diag_derecha_sup_y, x + ln + ca_diag_derecha_sup_x, pto_diag_izq_sup_down_y);
//        g2d.draw(completa1);
        
        g2d.setColor(Color.black);
         //Muro interior izq sup
         Line2D muro_int_sup_izq= new Line2D.Double(x, y, x, y - co_diag_derecha_sup_y - espacio_muro);
         g2d.draw(muro_int_sup_izq);
         //Muro interior dcho sup
         Line2D muro_int_sup_dcho= new Line2D.Double(x + ln, y, x + ln, y - co_diag_derecha_sup_y - espacio_muro);
         g2d.draw(muro_int_sup_dcho);
         //Muro interior izq inf
         Line2D muro_int_inf_izq= new Line2D.Double(x, y + h, x, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(muro_int_inf_izq);
         //Muro interior dcho inf
         Line2D muro_int_inf_dcho= new Line2D.Double(x + ln, y + h, x + ln, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(muro_int_inf_dcho);
         //Tapa muro izq
         Line2D tapa_muro_izq = new Line2D.Double(x - ca_diag_derecha_sup_x - espacio_muro, y - co_diag_derecha_sup_y - espacio_muro, x, y - co_diag_derecha_sup_y - espacio_muro);
         g2d.draw(tapa_muro_izq);
         //Base muro izq
         Line2D base_muro_izq = new Line2D.Double(x - ca_diag_derecha_sup_x - espacio_muro, y + h + co_diag_derecha_sup_y + espacio_muro, x, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(base_muro_izq);
         //Lado izq de muro izq
         Line2D lado_izq_mro_izq= new Line2D.Double(x - ca_diag_derecha_sup_x - espacio_muro, y - co_diag_derecha_sup_y - espacio_muro, x - ca_diag_derecha_sup_x - espacio_muro, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(lado_izq_mro_izq);
         //Tapa muro dcho
         Line2D tapa_muro_dcho = new Line2D.Double(x + ln, y - co_diag_derecha_sup_y - espacio_muro, x + ln + ca_diag_derecha_sup_x + espacio_muro, y - co_diag_derecha_sup_y - espacio_muro);
         g2d.draw(tapa_muro_dcho);
         //Base muro dcho
         Line2D base_muro_dcho = new Line2D.Double(x + ln, y + h + co_diag_derecha_sup_y + espacio_muro, x + ln + ca_diag_derecha_sup_x + espacio_muro, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(base_muro_dcho);
         //Lado dcho de muro dcho
         Line2D lado_dcho_mro_dcho= new Line2D.Double(x + ln + ca_diag_derecha_sup_x + espacio_muro, y - co_diag_derecha_sup_y - espacio_muro, x + ln + ca_diag_derecha_sup_x + espacio_muro, y + h + co_diag_derecha_sup_y + espacio_muro);
         g2d.draw(lado_dcho_mro_dcho);
         g2d.setColor(Color.red);
//       for(int i=y; i<=y+200; i+=50){
//           Line2D l7=new Line2D.Double(x, i, x+200, i);
//           g2d.draw(l7);
//       }
//       for(int i=x; i<=x+200; i+=50){
//           Line2D l8=new Line2D.Double(i, y, i, y+200);
//           g2d.draw(l8);
//       }
//       g2d.draw(l1);
//       g2d.draw(l2);
        g2d.setColor(Color.black);
        g2d.draw(l3);
        g2d.setColor(Color.red);
        g2d.draw(l4);
        g2d.setColor(Color.black);
        g2d.draw(l5);
        g2d.setColor(Color.red);
        g2d.draw(l6);
    }

    public void move() {
        x += 1;
        y += 1;
        System.out.println("ancho " + getWidth());
        System.out.println("alto " + getHeight());

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        calculo(g2d);
    }

}
