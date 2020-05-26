package io.holunda.command.mapper.value;


interface ValueConverter<S,T> {

  S from(T object);
  T convert(S object);

}
