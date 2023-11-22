import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;


public class Calculator {


    private JFrame mainFrame = new JFrame();

    private JLabel resultLabel = new JLabel();

    private JLabel memoryTextLabelData = new JLabel("0");
    private int activeFormula = 1;

    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;


    Calculator() {


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() * 480 / 1920;
        int height = gd.getDisplayMode().getHeight() * 400 / 1080;


        mainFrame.setSize(width, height);

        JButton buttonMemoryPlus = new JButton("M+");
        buttonMemoryPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double newValue = Double.parseDouble(resultLabel.getText()) + Double.parseDouble(memoryTextLabelData.getText());
                memoryTextLabelData.setText(newValue.toString());
            }
        });


        JButton buttonMemoryClear = new JButton("MC");
        buttonMemoryClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoryTextLabelData.setText("0");
            }
        });


        JRadioButton rbFormula1 = new JRadioButton("1");
        JRadioButton rbFormula2 = new JRadioButton("2");

        rbFormula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 1;
            }
        });

        rbFormula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 2;
            }
        });

        rbFormula1.setSelected(true);

        ButtonGroup formulaButtonGroup = new ButtonGroup();
        formulaButtonGroup.add(rbFormula1);
        formulaButtonGroup.add(rbFormula2);

        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        JButton buttonCalculate = new JButton("Calculate");

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double result = null;
                double x = Double.parseDouble(textFieldX.getText());
                double y = Double.parseDouble(textFieldY.getText());
                double z = Double.parseDouble(textFieldZ.getText());
                switch (Calculator.this.activeFormula) {
                    case (1) -> result = calculateFirstFormula(x, y, z);
                    case (2) -> result = calculateSecondFormula(x, y, z);
                }

                Calculator.this.resultLabel.setText(result.toString());
            }
        });


        JButton clearFieldsButton = new JButton("Clear Fields");

        clearFieldsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
            }
        });



        Box hboxFormulaChoice = Box.createHorizontalBox();
        hboxFormulaChoice.add(Box.createHorizontalGlue());
        hboxFormulaChoice.add(rbFormula1);
        hboxFormulaChoice.add(rbFormula2);
        hboxFormulaChoice.add(Box.createHorizontalGlue());

        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(buttonMemoryPlus);
        hboxMemory.add(buttonMemoryClear);
        hboxMemory.add(Box.createHorizontalStrut(20));
        hboxMemory.add(memoryTextLabelData);
        hboxMemory.add(Box.createHorizontalGlue());



        Box hboxVariables = Box.createHorizontalBox();

        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);



        Box hboxCalculate = Box.createHorizontalBox();
        hboxCalculate.add(buttonCalculate);
        hboxCalculate.add(clearFieldsButton);


        Box resultBox = Box.createHorizontalBox();
        resultBox.add(Box.createHorizontalBox());
        resultBox.add(new JLabel("Result: "));
        resultBox.add(resultLabel);


        Box contentBox = Box.createVerticalBox();
        contentBox.add(hboxFormulaChoice);
        contentBox.add(hboxVariables);
        contentBox.add(hboxMemory);
        contentBox.add(hboxCalculate);
        contentBox.add(resultBox);
        contentBox.add(Box.createVerticalGlue());

        mainFrame.getContentPane().add(contentBox);
    }

    private Double calculateFirstFormula(Double x, Double y, Double z) {
        return ((1 / Math.sqrt(x)) + (Math.cos(Math.exp(x))) + (Math.cos(Math.pow(z, 2)))) / (Math.pow((log10(Math.pow((1 + z), 2)) + Math.sqrt(exp(Math.cos(y)) + Math.pow(Math.sin(PI * x), 2))), 1. / 3.));
    }

    private Double calculateSecondFormula(Double x, Double y, Double z) {
        return Math.pow(y + Math.pow(x, 3), z) / log10(z);
    }

    public void setVisible(boolean state) {
        mainFrame.setVisible(state);
    }
}
