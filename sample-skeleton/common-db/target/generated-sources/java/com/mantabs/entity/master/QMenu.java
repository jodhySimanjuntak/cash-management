package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = -1702808989L;

    public static final QMenu menu = new QMenu("menu");

    public final NumberPath<java.math.BigDecimal> id = createNumber("id", java.math.BigDecimal.class);

    public final StringPath moduleName = createString("moduleName");

    public final NumberPath<java.math.BigDecimal> orderNo = createNumber("orderNo", java.math.BigDecimal.class);

    public final StringPath pageName = createString("pageName");

    public final StringPath pageTitle = createString("pageTitle");

    public final StringPath parentPageName = createString("parentPageName");

    public final StringPath viewModel = createString("viewModel");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

