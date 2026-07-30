<%@ page pageEncoding="UTF-8" %>

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
                <form class="mt-4 text-start" action="/contact-form" method="POST">
                    <div class="mb-3">
                        <label for="name" class="form-label">Ваше имя</label>
                        <input type="text" class="form-control" id="name" placeholder="Иван Иванов" name="name" />
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" />
                    </div>
                    <div class="mb-3">
                        <label for="message" class="form-label">Сообщение</label>
                        <textarea class="form-control" id="message" rows="4" name="message"
                            placeholder="Расскажите, что хотите заказать..."></textarea>
                    </div>
                    <button type="submit" class="btn btn-golden w-100">Отправить</button>
                </form>
            </div>
        </div>
    </div>
</section>