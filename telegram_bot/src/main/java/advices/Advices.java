package advices;

public enum Advices {
    HAT("Юляш, не забудь шапку"),
    CARDS("Юляш, не теряй банковские карты, там денежка на корм Жанне"),
    SMILE("Юляш, улыбайся=)"),
    WORK("Юляш, уходи с работы вовремя. Они там справятся"),
    GLASSES("Юляш, не забудь очки"),
    PHONE("Юляш, проверь на месте ли телефон"),
    KEYS("Юляш, проверь не забыла ли ты ключи от квартиры"),
    LEGS("Юляш, смотри под ноги, ты хоть и Котя, но группироваться при падении еще не умеешь"),
    FRACTURE("Юляш, не ломай пожалуйста себе ничего больше. Я расстроюсь(("),
    STOP("Юляш, не проезжай свою остановку)"),
    BONUS("Тын-дын-дын. !!!БОНУС!!! Ты получаешь +10 к навыку отгадывания транскрипций имен гостей из ближнего зарубежья"),
    SLEEP("Юляш, ложись пораньше.. Высыпайся=)"),
    FORGET("Юляш, не забывай ничего не забывать)"),
    CHARGER("Юляш, проверь на месте ли зарядка для телефона"),
    SLEEP_MORE("Юляш, поспи еще немножечко)))"),
    POWER("Юляш, лучей сил тебе))"),
    CRICKET("Юляш, проверь плотно ли закрыта коробка со сверчками, а то придется бежать)"),
    MEMS("Юляш, полистай мемчики с котиками. Релаксируй"),
    VINE("Юляш, лови винишко и плед!"),
    PROGERS("Юляш, поругай программистов. Пусть не расслабляются"),
    NOTEBOOK("+10 к прочности ноутбука"),
    BUSYA("+10 к урону Бусе"),
    BEZE("Будь осторожна с безе. Оно коварное"),
    HOBBIT("Слава повелительнице хоббитов!!!"),
    KOTYA("Это кто здесь котя?)"),
    EQUILIBRIUM("Юляш, держи равновесие. Кто, если не ты?)");

    private String advice;

    Advices(String advice) {
        this.advice = advice;
    }

    public String getAdvice() {
        return advice;
    }

}