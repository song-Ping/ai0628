package com.example.minStudy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFreeBoard is a Querydsl query type for FreeBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoard extends EntityPathBase<FreeBoard> {

    private static final long serialVersionUID = 1878580533L;

    public static final QFreeBoard freeBoard = new QFreeBoard("freeBoard");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final StringPath title = createString("title");

    public QFreeBoard(String variable) {
        super(FreeBoard.class, forVariable(variable));
    }

    public QFreeBoard(Path<? extends FreeBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreeBoard(PathMetadata metadata) {
        super(FreeBoard.class, metadata);
    }

}

