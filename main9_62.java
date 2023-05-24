import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main9_62 {
    public static void main(String[] args) {
        List<String> families = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите информацию о семьях:");
        while (true) {
            String familyInfo = scanner.nextLine();
            if (familyInfo.isEmpty()) {
                break;
            }
            families.add(familyInfo);
        }

        Map<String, Integer> poorFamiliesByRegion = new HashMap<>();

        int computerFamiliesCount = 0;

        for (String family : families) {
            String[] familyData = family.split(",");
            String region = familyData[0];
            int incomePerMember = Integer.parseInt(familyData[1]);
            int membersCount = Integer.parseInt(familyData[2]);
            boolean hasComputer = Boolean.parseBoolean(familyData[3]);
        }}}