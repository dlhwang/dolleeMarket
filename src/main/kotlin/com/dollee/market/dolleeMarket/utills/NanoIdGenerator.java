package com.dollee.market.dolleeMarket.utills;

import java.io.Serial;
import java.io.Serializable;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class NanoIdGenerator implements IdentifierGenerator, Serializable {

  @Serial private static final long serialVersionUID = -7858266607422294454L;

  @Override
  public Serializable generate(
      SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
    return NanoIdUtils.randomNanoId();
  }
}
