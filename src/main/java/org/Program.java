package org;

import org.controller.Controller;
import org.storage.Storage;
import org.view.IView;
import org.view.View;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    /**
     * Основной цикл приложения, где происходит обработка основных команд
     * (добавть животное, показать команды животного, выписать из питомника)
     */
    public static void run() {
        Controller controller = new Controller(new Storage());
        IView view = new View(controller);

        while (true) {
            view.showRegistry();
            View.MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> {
                    view.showDetailInfoAnimalDialog();
                }
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1 ? "Выписано животное" + removeId : "Не удалось  выписать животное";
                    System.out.println(resMessage);
                }
                case EXIT -> {
                    System.out.println("До скорого!... )");
                    return;
                }
            }
        }
    }
}
