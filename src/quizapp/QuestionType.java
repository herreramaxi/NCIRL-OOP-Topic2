/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

/**
 *
 * @author Maximiliano Herrera
 */
//I took he idea from https://stackoverflow.com/questions/15989316/how-to-add-a-description-for-each-entry-of-enum
public enum QuestionType {
    Question("Question"),
    MultipleChoice("Multiple choice"),
    Essay("Essay");

   
    private String value;

    QuestionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static QuestionType getEnum(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (QuestionType v : values()) {
            if (value.equalsIgnoreCase(v.getValue())) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    //Added by myself
    public static String[] getEnumDescriptions() {
        String[] enumDescriptions = new String[values().length];
        int i = 0;

        for (QuestionType v : values()) {
            enumDescriptions[i++] = v.toString();
        }

        return enumDescriptions;
    }
    
     static Object getEnumDescription(QuestionType questionType) {
       for (QuestionType v : values()) {
           if(v == questionType )
               return v.toString();
        }
       
       return QuestionType.Question.toString();
    }

}
