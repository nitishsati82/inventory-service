package com.nagp.inventory_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Table(name="inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Inventory {
    @Id
    private String productId;
    private String sellerId;
    private Integer stockCount;
    private String location;
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    protected LocalDateTime modifiedAt;

    private LocalDateTime getCurrentTimeStamp() {
        return LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = this.modifiedAt = getCurrentTimeStamp();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = getCurrentTimeStamp();
    }

}
