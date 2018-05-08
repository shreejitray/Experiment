package SQLGenerator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by schaud3 on 8/7/17.
 */
public class SqlGenerator {
    private static BufferedWriter bufferedWriter;
    private static FileWriter fileWriter;
    public static void main(String[] args) throws IOException {
        fileWriter = new FileWriter("/Users/schaud3/Documents/personal/Experiments/src/main/java/SQLGenerator/output");
        bufferedWriter = new BufferedWriter(fileWriter);
        Scanner IAMMapping = new Scanner(new File("/Users/schaud3/Documents/personal/Experiments/src/main/java/SQLGenerator/IAMMapping"));
        Scanner SQLStatements = new Scanner(new File("/Users/schaud3/Documents/personal/Experiments/src/main/java/SQLGenerator/SQLStatements"));
        Scanner SecurityStatements = new Scanner(new File("/Users/schaud3/Documents/personal/Experiments/src/main/java/SQLGenerator/SequrityQuestions"));
        Map<String,String> prinicipalIdMap = new HashMap<String, String>();

        Map<String,String> IAMIds = getIAMIds(IAMMapping);
        bufferedWriter.write("IAM insert queries: ");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.flush();
        while (SQLStatements.hasNext()) {
            String entry = SQLStatements.nextLine();
            String principalId = entry.substring(477,513);
            String newPrincipalId = UUID.randomUUID().toString();
            String insertQuery = entry.replace(principalId,newPrincipalId);
            String oldRealmId = insertQuery.substring(516,552);
            if(IAMIds.containsKey(oldRealmId)) {
                insertQuery = insertQuery.replace(oldRealmId,IAMIds.get(oldRealmId));
                bufferedWriter.write(insertQuery);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            prinicipalIdMap.put(principalId,newPrincipalId);
        }
        bufferedWriter.newLine();
        bufferedWriter.write("Security Questions: ");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.flush();
        while (SecurityStatements.hasNext()) {
            String entry = SecurityStatements.nextLine();
            String principalId = entry.substring(200,236);
            String newInsertQuery = entry.replace(principalId,prinicipalIdMap.get(principalId));
            String newUUID = UUID.randomUUID().toString();
            String oldUUID = newInsertQuery.substring(161,197);
            newInsertQuery = newInsertQuery.replace(oldUUID,newUUID);
            bufferedWriter.write(newInsertQuery);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        fileWriter.close();
        System.out.println(IAMIds.size());
    }

    private static Map<String,String> getIAMIds(Scanner iamMapping) {
        Map<String, String> IAMids = new HashMap<String, String>();
        while (iamMapping.hasNext()) {
            String entry[] = iamMapping.nextLine().split(",");
            if (entry[1].matches("^.{8}-.{4}-.{4}-.{4}-.{12}$")) {
                IAMids.put(entry[1], entry[2]);
            }
        }
        return IAMids;
    }
}
