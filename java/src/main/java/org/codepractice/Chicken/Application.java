package org.codepractice.Chicken;



import org.codepractice.Chicken.domain.Menu;
import org.codepractice.Chicken.domain.MenuRepository;
import org.codepractice.Chicken.domain.Table;
import org.codepractice.Chicken.domain.TableRepository;
import org.codepractice.Chicken.view.InputView;
import org.codepractice.Chicken.view.OutputView;

import java.util.List;

public class Application {

    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
    }
}
