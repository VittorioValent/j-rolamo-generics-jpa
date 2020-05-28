package it.contrader.jrolamo.generics.mapper;

import java.util.List;

import org.mapstruct.Named;

/**
 * @author Vittorio Valent
 * @since 0.0.1
 *
 */
public interface ListMapper {

	@Named(value = "listToSize")
	public static Integer listToSize(List<?> list) {
		if (list == null) {
			return 0;
		} else {
			return list.size();
		}
	}
}
