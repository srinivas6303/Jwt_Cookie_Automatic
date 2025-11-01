# 🛡️ JWT Authentication - Manual vs Automatic (With Cookies)

This Spring Boot project demonstrates **JWT-based authentication** in two different ways:
1. **Without Cookie (Manual Token Handling)**
2. **With Cookie (Automatic Token Handling)**

---

## 🚀 Project Overview

This project helps you understand how to secure REST APIs using **JSON Web Tokens (JWT)** — both manually and automatically using **HTTP cookies**.

| Branch | Description |
|---------|--------------|
| [`WithoutCookie-Manual`](https://github.com/srinivas6303/Jwt_Cookie_Automation/tree/WithoutCookie-manual) | Uses manual JWT handling — token is returned in response and must be manually copied to Authorization header. |
| [`WithCookie-Automation`](https://github.com/srinivas6303/jwt_Cookie_Automation/tree/WithCookie-Automation) | Uses automated JWT handling — token is stored inside an HttpOnly cookie, automatically sent in each request. |

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **Jakarta Servlet API**
- **JWT (io.jsonwebtoken - JJWT library)**

---

## ⚙️ How It Works

### 🔹 1. Manual Token Flow (WithoutCookie-Manual)
- User logs in with `/login` (username & password).
- Server returns a **JWT token** in the response body.
- Client manually adds it to **Authorization header**:
- Server verifies and grants access to protected endpoints.

---

### 🔹 2. Automatic Token Flow (WithCookie-Automation)
- User logs in with `/login`.
- Server generates a **JWT token** and stores it in an **HttpOnly cookie**.
- Browser/Postman automatically sends the cookie on every subsequent request.
- The backend reads the token from cookies and validates it automatically.

✅ No need to manually copy or paste tokens.

---

## 🧠 Example Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/login` | Authenticates user and sends JWT (manual or cookie). |
| `GET` | `/welcome` | Protected endpoint — accessible only with a valid JWT. |

---

## 🔐 Credentials (for demo)

| Username | Password |
|-----------|-----------|
| `Srinivas` | `Srinu@123` |

---

## 🧰 Project Setup

```bash
# Clone the repository
git clone https://github.com/username/jwt-cookie-simple.git

# Switch to desired branch
git checkout WithoutCookie-Manual   # or WithCookie-Automation

# Run the application
mvn spring-boot:run
```

---

## 💡 Author
Srinivas Dappu
Java Full Stack Developer
Hyderabad, Telangana
LinkedIn: https://www.linkedin.com/in/dappusrinivas/
