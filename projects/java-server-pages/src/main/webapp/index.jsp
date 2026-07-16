<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.time.Year" %>

<%
    boolean shouldDisplayContactForm = true;
%>

<%!
    class MenuItem {
        private final String name;
        private final String link;

        public MenuItem(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public String getLink() {
            return link;
        }
    }
%>

<%
    MenuItem[] menuItems = {
        new MenuItem("Меню", "#menu"),
        new MenuItem("Контакты", "#contact"),
        new MenuItem("О нас", "#about")
    };
%>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Пекарня</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous" />
        <link href="resources/styles/default.css" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm sticky-top">
            <div class="container">
                <a class="navbar-brand fw-bold text-dark" href="#">Пекарня</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <% for (MenuItem menuItem : menuItems) { %>
                            <li class="nav-item">
                                <a class="nav-link" href="<%= menuItem.getLink() %>">
                                    <%= menuItem.getName() %>
                                </a>
                            </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="hero text-center">
            <div class="container">
                <h1 class="display-4 fw-bold mb-3">Свежесть в каждом кусочке</h1>
                <p class="lead mb-4" style="max-width: 600px; margin-left: auto; margin-right: auto;">
                    Выпечка по семейным рецептам, натуральные ингредиенты и любовь к делу &mdash; вот наш секрет.
                </p>
                <a href="#menu" class="btn btn-golden btn-lg">Посмотреть меню</a>
            </div>
        </header>
        <section id="about" class="py-5">
            <div class="container text-center">
                <h2 class="section-title fw-bold">О нашей пекарне</h2>
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <p class="text-muted">
                            Пекарня открылась в 2021 году как маленькая семейная пекарня. Мы верим, что хорошая выпечка
                            &mdash; это не только вкус, но и настроение. Все изделия готовим утром, чтобы к обеду они были свежими
                            и ароматными. Используем только натуральные продукты и не добавляем искусственных усилителей
                            вкуса.
                        </p>
                    </div>
                </div>
            </div>
        </section>
        <section id="menu" class="bg-white py-5">
            <div class="container">
                <h2 class="section-title fw-bold">Наши хиты</h2>
                <div class="row g-4">
                    <div class="col-md-4 col-sm-6">
                        <div class="product-card">
                            <img src="resources/images/cinnamon_bun.jpg"
                                class="rounded-4 w-100 mb-3" alt="Булочка с корицей" />
                            <h5 class="fw-bold">Булочка с корицей</h5>
                            <p class="text-muted mb-3">Нежная сдобная булочка с ароматной корицей и глазурью.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="fs-5 fw-bold">220 ₽</span>
                                <button class="btn btn-outline-dark btn-sm">В корзину</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="product-card">
                            <img src="resources/images/croissant.jpg"
                                class="rounded-4 w-100 mb-3" alt="Круассан классический" />
                            <h5 class="fw-bold">Круассан классический</h5>
                            <p class="text-muted mb-3">Хрустящий снаружи, воздушный внутри &mdash; как в лучших парижских пекарнях.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="fs-5 fw-bold">180 ₽</span>
                                <button class="btn btn-outline-dark btn-sm">В корзину</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="product-card">
                            <img src="resources/images/hero.jpg"
                                class="rounded-4 w-100 mb-3" alt="Хлеб на закваске" />
                            <h5 class="fw-bold">Хлеб на закваске</h5>
                            <p class="text-muted mb-3">Плотный мякиш, хрустящая корочка и глубокий хлебный аромат.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="fs-5 fw-bold">350 ₽</span>
                                <button class="btn btn-outline-dark btn-sm">В корзину</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="contact" class="py-5">
            <div class="container text-center">
                <h2 class="section-title fw-bold">Приходите к нам</h2>
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <p class="lead text-muted">
                            📍 г. Москва, ул. Пекарская, д. N<br />
                            🕒 Ежедневно с 08:00 до 20:00<br />
                            📞 +7 (999) 123-45-67
                        </p>
                        <% if (shouldDisplayContactForm) { %>
                            <form class="mt-4 text-start">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Ваше имя</label>
                                    <input type="text" class="form-control" id="name" placeholder="Иван Иванов" />
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" placeholder="name@example.com" />
                                </div>
                                <div class="mb-3">
                                    <label for="message" class="form-label">Сообщение</label>
                                    <textarea class="form-control" id="message" rows="4"
                                        placeholder="Расскажите, что хотите заказать..."></textarea>
                                </div>
                                <button type="submit" class="btn btn-golden w-100">Отправить</button>
                            </form>
                        <% } else { %>
                            <p>К сожалению, все операторы сейчас заняты :(</p>
                        <% } %>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            <div class="container text-center">
                <p class="mb-0">&copy; <%= Year.now() %> г. Пекарня. Все права защищены.</p>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>
</html>