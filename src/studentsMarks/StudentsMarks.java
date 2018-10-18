package studentsMarks;

import java.util.*;

public class StudentsMarks {
    public static void main(String[] args) {
        System.out.println("Dobrij denj");

        Map<String, Double> studentInfo = new HashMap<>();

        studentInfo.put("Vasja Pupkin", 9.2);
        studentInfo.put("Petja Vase4kin", 4.3);
        loop:while (true) {
            System.out.println("Viberite dejstvie :\n 1. Vvesti informaciju ob u4enike;  \n 2. Srednjaja ocenka vsex u4enikom \n 3. Samij ne uspevaemij u4enik \n 4. Samij uspevaemij u4enik \n 5. Pokazatj spisok iz vsex u4enikov \n 6.Vijti iz sistemi");
            Scanner sc = new Scanner(System.in);
            int userChoice = sc.nextInt();
            Double average;
            switch (userChoice){
                case 1:
                    System.out.print("VVedite imja i familiju u4enika");
                    sc.nextLine();
                    String nameSurname = sc.nextLine();
                    System.out.println();
                    System.out.print("VVedite ego ocenku kak razdelitelj ispoljzuja zapjatuju");
                    Double studentMark = sc.nextDouble();
                    System.out.println();

                    studentInfo.put(nameSurname, studentMark);
                    System.out.println("Dannie zapisanni");
                    break;
                case 2:
                    Double sum = 0.0;
                    for (Double f : studentInfo.values()) {
                        sum += f;
                    }
                    average = sum / studentInfo.size();
                    System.out.println("Vsego u4atsja " + studentInfo.size() + " u4enikom i ix srednjaja ocenka " + average + " ballov");
                    break;
                case 3:
                    minMarkStudent(studentInfo);
                    break;
                case 4:
                    maxMarkStudent(studentInfo);
                    break;
                case 5:
                    showAllStudents(studentInfo);
                    break;
                case 6:
                    System.out.println("Vi viwli iz sistemi");
                    break loop;

            }
        }
    }
        public static void minMarkStudent (Map < String, Double > studentInfo){
            Map.Entry<String, Double> minMark = null;
            for (Map.Entry<String, Double> entry : studentInfo.entrySet()) {
                if (minMark == null || minMark.getValue() > entry.getValue()) {
                    minMark = entry;
                }
            }
            System.out.println(minMark.getKey() + " Samij neuvpevajuwij u4enik, ego srednij ball: " + minMark.getValue());
        }

        public static void maxMarkStudent (Map < String, Double > studentInfo){
            Map.Entry<String, Double> maxMark = null;
            for (Map.Entry<String, Double> entry : studentInfo.entrySet()) {
                if (maxMark == null || maxMark.getValue() < entry.getValue()) {
                    maxMark = entry;
                }
            }
            System.out.println(maxMark.getKey() + " Samij uspevajuwij u4enik, ego srednij ball: " + maxMark.getValue());
        }
        public static void showAllStudents(Map < String, Double > studentInfo){
            for (Map.Entry<String, Double> entry : studentInfo.entrySet()) {
                System.out.println("Imja i Familija: " + entry.getKey() + "; Srednij bal: " + entry.getValue());
            }
        }
    }