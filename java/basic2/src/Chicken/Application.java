package Chicken;

import Chicken.domain.Menu;
import Chicken.domain.MenuRepository;
import Chicken.domain.Table;
import Chicken.domain.TableRepository;
import Chicken.view.InputView;
import Chicken.view.OutputView;
import java.util.List;

public class Application {

    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
