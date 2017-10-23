/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.mycompany.mavenproject1.AllResult;
import com.mycompany.mavenproject1.SelfResult;
import com.mycompany.mavenproject1.beans.AllResultFacade;
import com.mycompany.mavenproject1.beans.SelfResultFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zekart
 */
@ManagedBean
@SessionScoped
public class GetResult implements Serializable {

    @EJB
    private SelfResultFacade resultFacade;
    @EJB
    private AllResultFacade allResultFacade;

    private SelfResult result = new SelfResult();
    private List<SelfResult> result_list = new ArrayList<>();
    private List<AllResult> all_result_list = new ArrayList<>();
    private List<AllResult> exit_result_list = new ArrayList<>();

    double[] cof = {0.2, 0.4, 0.6, 0.8, 1};
    int[] people = new int[5];
    double[] ex_res_n = new double[4];
    double[] ex_res_f = new double[4];
    

    public GetResult() {
    }

    @PostConstruct
    public void init() {
        
        result_list = resultFacade.findAll();

        if (result_list.size() > 0) {
            int id = 0;
            for (SelfResult selfResult1 : result_list) {
                id = selfResult1.getId();
            }

            result = resultFacade.find(id);
        }

        people = findPeople();
        ex_res_n = resultNow(people);
        ex_res_f = resultFeature(people);
        

    }

    public int[] findPeople() {
        int[] countPeople = new int[5];
        int student = 0;
        int aspirant = 0;
        int asistent = 0;
        int docent = 0;
        int profesor = 0;

        all_result_list = allResultFacade.findAll();
        for (AllResult u : all_result_list) {
            if (u.getRole().equals("Студент")) {
                student += 1;
            }
            if (u.getRole().equals("Аспирант")) {
                aspirant += 1;
            }
            if (u.getRole().equals("Ассистент")) {
                asistent += 1;
            }
            if (u.getRole().equals("Доцент")) {
                docent += 1;
            }
            if (u.getRole().equals("Профессор")) {
                profesor += 1;
            }
        }
        countPeople[0] = student;
        countPeople[1] = aspirant;
        countPeople[2] = asistent;
        countPeople[3] = docent;
        countPeople[4] = profesor;

        for (int i = 0; i < countPeople.length; i++) {
            System.out.println("People" + countPeople[i]);
        }
        return countPeople;
    }

    public double[] resultNow(int[] mascount) {

        exit_result_list = allResultFacade.findAll();
        double[] ex_result_now = new double[4];

        double[] countAn = new double[5];
        double[] countBn = new double[5];
        double[] countCn = new double[5];
        double[] countDn = new double[5];

        double aN = 0;
        double bN = 0;
        double cN = 0;
        double dN = 0;

        double studentAn = 0;
        double aspirantAn = 0;
        double asistentAn = 0;
        double docentAn = 0;
        double profesorAn = 0;

        double studentBn = 0;
        double aspirantBn = 0;
        double asistentBn = 0;
        double docentBn = 0;
        double profesorBn = 0;

        double studentCn = 0;
        double aspirantCn = 0;
        double asistentCn = 0;
        double docentCn = 0;
        double profesorCn = 0;

        double studentDn = 0;
        double aspirantDn = 0;
        double asistentDn = 0;
        double docentDn = 0;
        double profesorDn = 0;

        for (AllResult u : all_result_list) {
            if (u.getRole().equals("Студент")) {
                studentAn += Double.parseDouble(u.getAN());
                studentBn += Double.parseDouble(u.getBN());
                studentCn += Double.parseDouble(u.getCN());
                studentCn += Double.parseDouble(u.getDN());
            }
            if (u.getRole().equals("Аспирант")) {
                aspirantAn += Double.parseDouble(u.getAN());
                aspirantBn += Double.parseDouble(u.getBN());
                aspirantCn += Double.parseDouble(u.getCN());
                aspirantDn += Double.parseDouble(u.getDN());

            }
            if (u.getRole().equals("Ассистент")) {
                asistentAn += Double.parseDouble(u.getAN());
                asistentBn += Double.parseDouble(u.getBN());
                asistentCn += Double.parseDouble(u.getCN());
                asistentDn += Double.parseDouble(u.getDN());
            }
            if (u.getRole().equals("Доцент")) {
                docentAn += Double.parseDouble(u.getAN());
                docentBn += Double.parseDouble(u.getBN());
                docentCn += Double.parseDouble(u.getCN());
                docentDn += Double.parseDouble(u.getDN());
            }
            if (u.getRole().equals("Профессор")) {
                profesorAn += Double.parseDouble(u.getAN());
                profesorBn += Double.parseDouble(u.getBN());
                profesorCn += Double.parseDouble(u.getCN());
                profesorDn += Double.parseDouble(u.getDN());
            }
        }

        for (int i = 0; i < mascount.length; i++) {
            if (mascount[i] == 0) {
                mascount[i] = 1;
            }

        }

        countAn[0] = (studentAn / mascount[0]) * 0.2;
        countAn[1] = (aspirantAn / mascount[1]) * 0.4;
        countAn[2] = (asistentAn / mascount[2]) * 0.6;
        countAn[3] = (docentAn / mascount[3]) * 0.8;
        countAn[4] = (profesorAn / mascount[4]) * 1;

        countBn[0] = (studentBn / mascount[0]) * 0.2;
        countBn[1] = (aspirantBn / mascount[1]) * 0.4;
        countBn[2] = (asistentBn / mascount[2]) * 0.6;
        countBn[3] = (docentBn / mascount[3]) * 0.8;
        countBn[4] = (profesorBn / mascount[4]) * 1;

        countCn[0] = (studentCn / mascount[0]) * 0.2;
        countCn[1] = (aspirantCn / mascount[1]) * 0.4;
        countCn[2] = (asistentCn / mascount[2]) * 0.6;
        countCn[3] = (docentCn / mascount[3]) * 0.8;
        countCn[4] = (profesorCn / mascount[4]) * 1;

        countDn[0] = (studentDn / mascount[0]) * 0.2;
        countDn[1] = (aspirantDn / mascount[1]) * 0.4;
        countDn[2] = (asistentDn / mascount[2]) * 0.6;
        countDn[3] = (docentDn / mascount[3]) * 0.8;
        countDn[4] = (profesorDn / mascount[4]) * 1;

        for (int i = 0; i < countAn.length; i++) {
            aN += countAn[i];
            bN += countBn[i];
            cN += countCn[i];
            dN += countDn[i];
        }
        System.out.println("An" + aN + "  Bn" + bN + "  Cn" + cN + "  Dn" + dN);
        ex_result_now[0] = Math.round(aN);
        ex_result_now[1] = Math.round(bN);
        ex_result_now[2] = Math.round(cN);
        ex_result_now[3] = Math.round(dN);

        return ex_result_now;
    }
    public double[] resultFeature(int[] mascount) {

        exit_result_list = allResultFacade.findAll();
        double[] ex_result_f = new double[4];

        double[] countAf = new double[5];
        double[] countBf = new double[5];
        double[] countCf = new double[5];
        double[] countDf = new double[5];

        double aF = 0;
        double bF = 0;
        double cF = 0;
        double dF = 0;

        double studentAf = 0;
        double aspirantAf = 0;
        double asistentAf = 0;
        double docentAf = 0;
        double profesorAf = 0;

        double studentBf = 0;
        double aspirantBf = 0;
        double asistentBf = 0;
        double docentBf = 0;
        double profesorBf = 0;

        double studentCf = 0;
        double aspirantCf = 0;
        double asistentCf = 0;
        double docentCf = 0;
        double profesorCf = 0;

        double studentDf = 0;
        double aspirantDf = 0;
        double asistentDf = 0;
        double docentDf = 0;
        double profesorDf = 0;

        for (AllResult u : all_result_list) {
            if (u.getRole().equals("Студент")) {
                studentAf += Double.parseDouble(u.getAF());
                studentBf += Double.parseDouble(u.getBF());
                studentCf += Double.parseDouble(u.getCF());
                studentCf += Double.parseDouble(u.getDF());
            }
            if (u.getRole().equals("Аспирант")) {
                aspirantAf += Double.parseDouble(u.getAF());
                aspirantBf += Double.parseDouble(u.getBF());
                aspirantCf += Double.parseDouble(u.getCF());
                aspirantDf += Double.parseDouble(u.getDF());

            }
            if (u.getRole().equals("Ассистент")) {
                asistentAf += Double.parseDouble(u.getAF());
                asistentBf += Double.parseDouble(u.getBF());
                asistentCf += Double.parseDouble(u.getCF());
                asistentDf += Double.parseDouble(u.getDF());
            }
            if (u.getRole().equals("Доцент")) {
                docentAf += Double.parseDouble(u.getAF());
                docentBf += Double.parseDouble(u.getBF());
                docentCf += Double.parseDouble(u.getCF());
                docentDf += Double.parseDouble(u.getDF());
            }
            if (u.getRole().equals("Профессор")) {
                profesorAf += Double.parseDouble(u.getAF());
                profesorBf += Double.parseDouble(u.getBF());
                profesorCf += Double.parseDouble(u.getCF());
                profesorDf += Double.parseDouble(u.getDF());
            }
        }

        for (int i = 0; i < mascount.length; i++) {
            if (mascount[i] == 0) {
                mascount[i] = 1;
            }

        }

        countAf[0] = (studentAf / mascount[0]) * 0.2;
        countAf[1] = (aspirantAf / mascount[1]) * 0.4;
        countAf[2] = (asistentAf / mascount[2]) * 0.6;
        countAf[3] = (docentAf / mascount[3]) * 0.8;
        countAf[4] = (profesorAf / mascount[4]) * 1;

        countBf[0] = (studentBf / mascount[0]) * 0.2;
        countBf[1] = (aspirantBf / mascount[1]) * 0.4;
        countBf[2] = (asistentBf / mascount[2]) * 0.6;
        countBf[3] = (docentBf / mascount[3]) * 0.8;
        countBf[4] = (profesorBf / mascount[4]) * 1;

        countCf[0] = (studentCf / mascount[0]) * 0.2;
        countCf[1] = (aspirantCf / mascount[1]) * 0.4;
        countCf[2] = (asistentCf / mascount[2]) * 0.6;
        countCf[3] = (docentCf / mascount[3]) * 0.8;
        countCf[4] = (profesorCf / mascount[4]) * 1;

        countDf[0] = (studentDf / mascount[0]) * 0.2;
        countDf[1] = (aspirantDf / mascount[1]) * 0.4;
        countDf[2] = (asistentDf / mascount[2]) * 0.6;
        countDf[3] = (docentDf / mascount[3]) * 0.8;
        countDf[4] = (profesorDf / mascount[4]) * 1;

        for (int i = 0; i < countAf.length; i++) {
            aF += countAf[i];
            bF += countBf[i];
            cF += countCf[i];
            dF += countDf[i];
        }
        System.out.println("An" + aF + "  Bn" + bF + "  Cn" + cF + "  Dn" + dF);
        ex_result_f[0] = Math.round(aF);
        ex_result_f[1] = Math.round(bF);
        ex_result_f[2] = Math.round(cF);
        ex_result_f[3] = Math.round(dF);

        return ex_result_f;
    }    
    
    

    public double[] getEx_res_n() {
        return ex_res_n;
    }

    public void setEx_res_n(double[] ex_res_n) {
        this.ex_res_n = ex_res_n;
    }

    public double[] getEx_res_f() {
        return ex_res_f;
    }

    public void setEx_res_f(double[] ex_res_f) {
        this.ex_res_f = ex_res_f;
    }

    public SelfResultFacade getResultFacade() {
        return resultFacade;
    }

    public SelfResult getResult() {
        return result;
    }

    public List<SelfResult> getResult_list() {
        return result_list;
    }

    public AllResultFacade getAllResultFacade() {
        return allResultFacade;
    }

    public List<AllResult> getAll_result_list() {
        return all_result_list;
    }

    public void setAll_result_list(List<AllResult> all_result_list) {
        this.all_result_list = all_result_list;
    }

    public int[] getPeople() {
        return people;
    }

    public void setPeople(int[] people) {
        this.people = people;
    }

}
