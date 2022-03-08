package by.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Contract implements Serializable {
    private LocalDate date;
    private String number;
    private String type;
    private String department;
    private Integer reg;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Double sum;
    private String subject;
    private String unp;
    private String name;
    private String address;
    private String contacts;
    private String bankDetails;
    private String resident;
    private String side;
    private String termsPayment;

    public Contract(LocalDate date, String number, String type, String department, Integer reg, LocalDate startDate, LocalDate finishDate, Double sum, String subject, String unp, String name, String address, String contacts, String bankDetails, String resident, String side, String termsPayment) {
        this.date = date;
        this.number = number;
        this.type = type;
        this.department = department;
        this.reg = reg;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.sum = sum;
        this.subject = subject;
        this.unp = unp;
        this.name = name;
        this.address = address;
        this.contacts = contacts;
        this.bankDetails = bankDetails;
        this.resident = resident;
        this.side = side;
        this.termsPayment = termsPayment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getReg() {
        return reg;
    }

    public void setReg(Integer reg) {
        this.reg = reg;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUnp() {
        return unp;
    }

    public void setUnp(String unp) {
        this.unp = unp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTermsPayment() {
        return termsPayment;
    }

    public void setTermsPayment(String termsPayment) {
        this.termsPayment = termsPayment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "date=" + date +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", department='" + department + '\'' +
                ", reg=" + reg +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", sum=" + sum +
                ", subject='" + subject + '\'' +
                ", unp='" + unp + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contacts='" + contacts + '\'' +
                ", bankDetails='" + bankDetails + '\'' +
                ", resident='" + resident + '\'' +
                ", side='" + side + '\'' +
                ", termsPayment='" + termsPayment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(date, contract.date) && Objects.equals(number, contract.number) && Objects.equals(type, contract.type) && Objects.equals(department, contract.department) && Objects.equals(reg, contract.reg) && Objects.equals(startDate, contract.startDate) && Objects.equals(finishDate, contract.finishDate) && Objects.equals(sum, contract.sum) && Objects.equals(subject, contract.subject) && Objects.equals(unp, contract.unp) && Objects.equals(name, contract.name) && Objects.equals(address, contract.address) && Objects.equals(contacts, contract.contacts) && Objects.equals(bankDetails, contract.bankDetails) && Objects.equals(resident, contract.resident) && Objects.equals(side, contract.side) && Objects.equals(termsPayment, contract.termsPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, number, type, department, reg, startDate, finishDate, sum, subject, unp, name, address, contacts, bankDetails, resident, side, termsPayment);
    }
}


