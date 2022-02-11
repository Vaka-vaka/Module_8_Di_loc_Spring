package ua.goit.producers;

@FunctionalInterface
public interface BaseEntity<ID>  {
    ID getId();
}
