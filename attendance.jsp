<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Portal</title>
</head>
<body>
    <h2>Mark Attendance</h2>
    <form action="markAttendance" method="post">
        Roll Number: <input type="number" name="rollNo" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status:
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
