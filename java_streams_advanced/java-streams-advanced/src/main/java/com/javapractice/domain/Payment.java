package com.javapractice.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.javapractice.domain.types.PaymentMethodType;
import com.javapractice.domain.types.PaymentStatusType;

public class Payment {
	private PaymentMethodType method;
	private PaymentStatusType status;
	private BigDecimal amount;
	private LocalDateTime paidAt;
	
	public Payment(PaymentMethodType method, PaymentStatusType status, BigDecimal amount, LocalDateTime paidAt) {
		super();
		this.method = method;
		this.status = status;
		this.amount = amount;
		this.paidAt = paidAt;
	}

	public PaymentMethodType getMethod() {
		return method;
	}
	
	public void setMethod(PaymentMethodType method) {
		this.method = method;
	}
	
	public PaymentStatusType getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatusType status) {
		this.status = status;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, method, paidAt, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(amount, other.amount) && method == other.method && Objects.equals(paidAt, other.paidAt)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "Payment [method=" + method.name() + ", status=" + status.name() + ", amount=" + amount + ", paidAt=" + paidAt + "]";
	}
	
	
}
