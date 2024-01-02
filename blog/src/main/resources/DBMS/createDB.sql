CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(255) NOT NULL UNIQUE,  -- UNIQUE 제약 조건 추가
    username VARCHAR(255) NOT NULL UNIQUE,  -- UNIQUE 제약 조건 추가
    password VARCHAR(255) NOT NULL,
    email_local_part VARCHAR(255) NOT NULL, -- 이메일 주소의 로컬 파트 (예: "example" in "example@gmail.com")
    email_domain VARCHAR(255) NOT NULL,     -- 이메일 주소의 도메인 (예: "gmail.com")
	custom_email_domain VARCHAR(255),
    enabled TINYINT(1) NOT NULL
) DEFAULT CHARSET=utf8mb4;
