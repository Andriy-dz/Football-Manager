package footballmanager.service.mapper;

public interface RequestDtoMapper<T, D> {
    T mapToModel(D dto);
}
