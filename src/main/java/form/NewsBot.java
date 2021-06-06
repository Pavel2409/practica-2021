package form;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class NewsBot extends JFrame implements ActionListener {

    Map<String, String> validPassword = new HashMap<>();

    LoginForm loginForm;
    NewsForm newsForm;


    private void setValidPassword() {
        validPassword.put("admin", "0000");
        validPassword.put("user", "1111");
    }

    public NewsBot() {
        setValidPassword();
        loginForm = new LoginForm(this);

    }

    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginForm.loginButton) {
            String login, password;
            login = loginForm.userTextField.getText();
            password = loginForm.passwordField.getText();

            if(!validPassword.containsKey(login) || !password.equals(validPassword.get(login))) {
                JOptionPane.showMessageDialog(this, "Неверный логин или пароль");
                return;
            }
            loginForm.setVisible(false);
            newsForm = new NewsForm(login);

        }
        //Coding Part of RESET button
        if (e.getSource() == loginForm.resetButton) {
            loginForm.userTextField.setText("");
            loginForm.passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == loginForm.showPassword) {
            if (loginForm.showPassword.isSelected()) {
                loginForm.passwordField.setEchoChar((char) 0);
            } else {
                loginForm.passwordField.setEchoChar('*');
            }

        }
    }


}
