package org.view;

import org.model.Animal;

public interface IView {
    /**
     * Команды главного меню
     */
    enum MainMenuCommand {
        ADD_ANIMAL ("Добавить животное"),
        SHOW_SKILLS("Показать команды"),
        REMOVE_ANIMAL ("Выписать животное"),
        EXIT ("Выйти");

        private String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Команды меню обучения командам
     */
    enum AddMenuCommand {
        ADD_SKILL ("Обучить команде"),
        EXIT ("Выйти");

        private String tag;

        AddMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Показывает список живтоных в питомнике
     */
    void showRegistry();

    /**
     * Показывает основное меню приложения
     * @return Возвращает выбранную команду
     */
    MainMenuCommand showMainMenuWithResult();

    /**
     * Показывает диалог добавления животного
     * @return Возвращает true в при успешном добавлении, false - в противном случае
     */
    boolean showAddAnimalDialog();

    /**
     * Показывает диалог выписки животного из питомника
     * @return Возвращает id выписанного животного или -1 при ошибке
     */
    int showRemoveAnimalDialog();

    /**
     * Показывает диалог отображения детальной информации о животном
     */
    void showDetailInfoAnimalDialog();

    /**
     * Показывает детальную информацию о животном
     */
    void showAnimalInfo(Animal animal);

    /**
     * Показывает меню добавления команды
     * @return Возвращает выбранную команду
     */
    AddMenuCommand showAddCommandMenu(Animal animal);

    /**
     * Показывает диалог добавления навыка
     * @return Возвращает true в при успешном добавлении, false - в противном случае
     */
    boolean showAddCommandDialog(Animal animal);
}
