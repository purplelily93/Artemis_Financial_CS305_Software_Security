Artemis Financial – Secure Software Assessment
Client Overview

Artemis Financial is a financial services company that develops custom financial planning applications for its clients. The company required secure communication between its web application and users because it handled sensitive financial and personal data.

The primary issue Artemis Financial needed to address was the lack of secure data transmission and insufficient validation of application dependencies. The company required implementation of HTTPS, secure hashing, and vulnerability scanning to ensure client data remained protected.

Vulnerability Assessment Summary

During the assessment, I evaluated the application for security weaknesses using static dependency analysis and industry best practices. I identified vulnerabilities in outdated libraries and implemented mitigation techniques, including secure hashing and certificate configuration for encrypted communication.

Coding securely is critical because financial applications handle sensitive information such as personal identifiers and investment data. Security protects:

Client trust

Regulatory compliance

Company reputation

Financial stability

Software security adds value by preventing data breaches, reducing liability, and strengthening overall system resilience.

Challenges and Learning Experience

One of the more challenging aspects of the vulnerability assessment was interpreting dependency scan results and determining which vulnerabilities were critical versus informational.

However, this process was also extremely valuable because it strengthened my understanding of:

CVE classifications

Risk prioritization

Secure software lifecycle practices

Security Enhancements Implemented

To increase layers of security, I:

Configured HTTPS using a self-signed certificate

Implemented SHA-256 hashing for checksum validation

Ran OWASP Dependency-Check to identify known vulnerabilities

Applied suppression rules for false positives when appropriate

Verified secure communication over port 8443

In the future, I would use:

OWASP ZAP for dynamic testing

Snyk for dependency vulnerability monitoring

Automated CI/CD pipeline security scanning

Functional and Security Validation

After refactoring the application, I validated:

Successful HTTPS connection

Proper checksum output

Secure endpoint response

No new dependency vulnerabilities

I reran dependency scans and manually tested endpoints to ensure no new issues were introduced during changes.

Tools and Best Practices Used

Spring Boot

Maven

OWASP Dependency-Check

SHA-256 hashing

Secure SSL certificate configuration

Principle of least privilege

Secure coding standards

These tools and practices will be valuable in future DevSecOps and secure software development roles.

Portfolio Value for Employers

From this project, I can demonstrate:

Ability to conduct vulnerability assessments

Secure code implementation

Risk analysis and mitigation

Secure configuration of web applications

DevSecOps awareness

This project showcases my ability to integrate security into the software development lifecycle rather than treating it as an afterthought.
