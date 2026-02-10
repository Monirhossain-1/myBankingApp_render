//package com.example.MyBankingProject.service;
//
//
//import com.example.MyBankingProject.entity.Loan;
//import com.example.MyBankingProject.entity.LoanPayment;
//import com.example.MyBankingProject.repository.LoanRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class LoanPaymentService {
//
//    private final LoanRepository loanRepo;
//    private final LoanPaymentRepository paymentRepo;
//
//    public <LoanPaymentRepository> LoanPaymentService(LoanRepository loanRepo, LoanPaymentRepository paymentRepo) {
//        this.loanRepo = loanRepo;
//        this.paymentRepo = paymentRepo;
//    }
//
//    public LoanPayment payLoan(Long loanId, Double amount) {
//        Loan loan = loanRepo.findById(loanId).orElseThrow();
//        Double totalPaid = loan.getPayments().stream().mapToDouble(LoanPayment::getAmountPaid).sum();
//        Double remaining = (loan.getLoanAmount() + loan.getLoanAmount() * loan.getInterestRate() / 100) - totalPaid;
//
//        if(amount > remaining) throw new RuntimeException("Amount exceeds remaining loan balance");
//
//        LoanPayment payment = new LoanPayment();
//        payment.setLoan(loan);
//        payment.setAmountPaid(amount);
//        payment.setPaidDate(new Date());
//        payment.setRemainingAmount(remaining - amount);
//
//        paymentRepo.save(payment);
//
//        if(payment.getRemainingAmount() <= 0) {
//            loan.setStatus("PAID");
//            loanRepo.save(loan);
//        }
//
//        return payment;
//    }
//
//    public List<LoanPayment> getPayments(Long loanId) {
//        Loan loan = loanRepo.findById(loanId).orElseThrow();
//        return loan.getPayments();
//    }
//}
