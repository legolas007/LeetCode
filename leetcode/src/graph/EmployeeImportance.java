package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer,Employee> map= new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id, map);
    }

    private int dfs(int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        int sum = e.importance;
        for (int eid : e.subordinates) {
            sum += dfs(eid, map);
        }
        return sum;
    }
}
