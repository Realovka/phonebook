package by.company.phonebook.service.mapper;

public interface Mapper<E, D> {

    D mapToDto(E e);

    E mapToEntity(D d);
}
