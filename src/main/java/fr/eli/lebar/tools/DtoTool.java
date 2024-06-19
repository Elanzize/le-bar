package fr.eli.lebar.tools;


import org.modelmapper.ModelMapper;

public class DtoTool {

    private static ModelMapper mapper = new ModelMapper();

    //Soit des méthodes pour chaque Entity
//	public static Product convertToProduct(ProductDto dto) {
//		return mapper.map(dto, Product.class);
//	}
//
//	public static ProductDto convertToProductDto(Product prod) {
//		return mapper.map(prod, ProductDto.class);
//	}
//

    //Soit une méthode de conversion générique

    public static <TSource, TDestination>  TDestination convert(TSource obj, Class<TDestination> clazz) {

        //On peut ajouter des règles personnalisées

        //lien doc: https://modelmapper.org/getting-started/

        return mapper.map(obj, clazz);
    }

}