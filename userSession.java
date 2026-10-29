package f7motorparts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class userSession {

    private static String username;
    private static String role;

    public static void login(String user, String userRole) {
        username = user;
        role = userRole;
    }

    public static String getUsername() {
        return username;
    }

    public static String getRole() {
        return role;
    }

    public static boolean isLoggedIn() {
        return username != null && role != null;
    }

    public static boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }

    public static boolean isStaff() {
        return "staff".equalsIgnoreCase(role);
    }

    public static void recordLogout() {
        String sql = "UPDATE login_history "
                   + "SET logout_time = CURRENT_TIMESTAMP "
                   + "WHERE username = ? "
                   + "AND logout_time IS NULL "
                   + "ORDER BY login_time DESC LIMIT 1";

        try (Connection con = DBconnection.connect()) {
            if (con == null) {
                JOptionPane.showMessageDialog(
                    null,
                    "Unable to connect to the database.",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, username);
                int updated = pst.executeUpdate();

                if (updated == 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "No active login record was found for this user.",
                        "Logout Record",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Unable to record logout time:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void logout() {
        username = null;
        role = null;
    }
}