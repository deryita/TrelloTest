package pages;

import org.openqa.selenium.By;

public class WorkspacePage extends BasePage{

    By btn_createBoard = By.xpath("//*[contains(text(),'Create new board')]");

    By txt_boardName = By.xpath("//*[@data-testid='create-board-title-input']");

    By btn_create = By.xpath("//*[@data-testid='create-board-submit-button']");

    By lbl_boardTitle = By.cssSelector(".js-board-editing-target.board-header-btn-text");

    By btn_boardMenu = By.xpath("//*[@aria-label='Show menu']");

    By btn_expand = By.xpath("//*[contains(text(),'More')]");

    By btn_closeBoard = By.cssSelector(".board-menu-navigation-item-link.js-close-board");

    By btn_closeConfirm = By.xpath("//*[@value='Close']");

    By btn_deleteBoard = By.xpath("//*[@data-testid='close-board-delete-board-button']");

    By btn_deleteConfirm = By.xpath("//*[@data-testid='close-board-delete-board-confirm-button']");
    public boolean createBoard(String boardName) {

        if (isElementDisplayed(btn_createBoard)) {
            click(btn_createBoard);
        }

        enterText(boardName, txt_boardName);
        click(btn_create);
        return isElementDisplayed(lbl_boardTitle);
    }

    public int deleteBoard(){
        click(btn_boardMenu);
        click(btn_expand);
        click(btn_closeBoard);
        click(btn_closeConfirm);
        click(btn_deleteBoard);
        click(btn_deleteConfirm);
        return isElementExists(lbl_boardTitle);
    }
}
