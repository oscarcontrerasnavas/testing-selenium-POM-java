# Testing with selenium and Java using Page Object Model (POM)

This is a personal repository hosting notes on how to create a simple but useful Selenium project in Java. This is not the programming language I am more comfortable with, although following Selenium documentation is straight forward if you are already familiar with OPP using other language. 

Unlike my previous project with selenium using the **Bot Pattern** pattern, I use the **POM** "architecture". I started this document writing down some notes about the followed process. If you are already familiar or aren't interested in my loud thoughts, skip to the next section.

For this project, I created a test for another repository of mine at [https://nist-api-frontend.vercel.app/](https://nist-api-frontend.vercel.app/) which is a fronted in Next.js for [https://github.com/oscarcontrerasnavas/nist-webbook-scrapyrt-spider](https://github.com/oscarcontrerasnavas/nist-webbook-scrapyrt-spider).

## Thought process

- The project structure has two folders: `main`, and `test`. In the `main` directory I put the classes representing pages and the other, well, has the tests.
