package org.example.Abstract;

// ==================== ABSTRACT PRODUCT ====================

abstract class Button {
    abstract void paint();
}


// ==================== CONCRETE PRODUCTS ====================

// Mac Button
class MacButton extends Button {

    @Override
    void paint() {
        System.out.println("Rendering button in a Mac style");
    }
}


// Windows Button
class WindowButton extends Button {

    @Override
    void paint() {
        System.out.println("Rendering button in a Windows style");
    }
}


// ==================== ABSTRACT PRODUCT ====================

abstract class CheckBox {
    abstract void check();
}


// ==================== CONCRETE PRODUCTS ====================

// Mac Checkbox
class MacCheckBox extends CheckBox {

    @Override
    void check() {
        System.out.println("Rendering checkbox in a Mac style");
    }
}


// Windows Checkbox
class WindowCheckBox extends CheckBox {

    @Override
    void check() {
        System.out.println("Rendering checkbox in a Windows style");
    }
}


// ==================== ABSTRACT FACTORY ====================

abstract class GUIFactory {

    abstract Button createButton();

    abstract CheckBox createCheckBox();
}


// ==================== CONCRETE FACTORY ====================

// Mac Factory
class MacGUIFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}


// Windows Factory
class WindowGUIFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new WindowButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}


// ==================== CLIENT ====================

public class Main {

    static void init(GUIFactory factory) {

        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        button.paint();
        checkBox.check();
    }


    public static void main(String[] args) {

        // Client wants Windows style UI
        GUIFactory windowsFactory = new WindowGUIFactory();

        init(windowsFactory);


        // Client wants Mac style UI
        GUIFactory macFactory = new MacGUIFactory();

        init(macFactory);
    }
}

// Abstract Factory: used when we have multiple related products.
// If we had only one type of product, we could use the Factory Method pattern.
// Here, we have multiple related products, so we use the Abstract Factory pattern.
// We have one Abstract Factory and multiple Concrete Factories,
// and each Concrete Factory creates a family of related Concrete Products.

