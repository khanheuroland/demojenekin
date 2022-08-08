Feature: Login

  Scenario: Show popup message for wrong password login
    Given The login page is showed
    When The user attempt to login with username "khanh.tx@live.com" and wrong password "abc123"
    Then The popup message with content "Tên đăng nhập hoặc Mật khẩu không đúng" will be showed

