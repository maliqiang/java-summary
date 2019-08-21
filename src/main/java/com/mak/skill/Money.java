package com.mak.skill;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2019/5/8
 */
public class Money extends Number {

  private Double money;

  public Money() {}

  public Money(double money) {
    this.money = money;
  }

  /**
   * Returns the value of the specified number as an {@code int}, which may involve rounding or
   * truncation.
   *
   * @return the numeric value represented by this object after conversion to type {@code int}.
   */
  @Override
  public int intValue() {
    return this.money.intValue();
  }

  /**
   * Returns the value of the specified number as a {@code long}, which may involve rounding or
   * truncation.
   *
   * @return the numeric value represented by this object after conversion to type {@code long}.
   */
  @Override
  public long longValue() {
    return 0;
  }

  /**
   * Returns the value of the specified number as a {@code float}, which may involve rounding.
   *
   * @return the numeric value represented by this object after conversion to type {@code float}.
   */
  @Override
  public float floatValue() {
    return 0;
  }

  /**
   * Returns the value of the specified number as a {@code double}, which may involve rounding.
   *
   * @return the numeric value represented by this object after conversion to type {@code double}.
   */
  @Override
  public double doubleValue() {
    return 0;
  }
}
