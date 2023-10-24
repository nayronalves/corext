package br.com.corext.admcorext.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faqserv")
public class Faq {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;
    
    @Column(length = 900)
    private String answer;

    @Column
    private String importance;

    public Faq() {
    }

    public Faq(Long id, String question, String answer, String importance) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.importance = importance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Faq [id=" + id + ", question=" + question + ", answer=" + answer + ", importance=" + importance + "]";
    }
}
