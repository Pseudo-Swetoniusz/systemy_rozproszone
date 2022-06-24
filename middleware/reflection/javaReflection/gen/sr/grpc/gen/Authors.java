// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/author.proto

package sr.grpc.gen;

/**
 * Protobuf type {@code author.Authors}
 */
public final class Authors extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:author.Authors)
    AuthorsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Authors.newBuilder() to construct.
  private Authors(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Authors() {
    authors_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Authors();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Authors(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              authors_ = new java.util.ArrayList<sr.grpc.gen.Author>();
              mutable_bitField0_ |= 0x00000001;
            }
            authors_.add(
                input.readMessage(sr.grpc.gen.Author.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        authors_ = java.util.Collections.unmodifiableList(authors_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.AuthorProto.internal_static_author_Authors_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.AuthorProto.internal_static_author_Authors_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.Authors.class, sr.grpc.gen.Authors.Builder.class);
  }

  public static final int AUTHORS_FIELD_NUMBER = 1;
  private java.util.List<sr.grpc.gen.Author> authors_;
  /**
   * <code>repeated .author.Author authors = 1;</code>
   */
  @java.lang.Override
  public java.util.List<sr.grpc.gen.Author> getAuthorsList() {
    return authors_;
  }
  /**
   * <code>repeated .author.Author authors = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends sr.grpc.gen.AuthorOrBuilder> 
      getAuthorsOrBuilderList() {
    return authors_;
  }
  /**
   * <code>repeated .author.Author authors = 1;</code>
   */
  @java.lang.Override
  public int getAuthorsCount() {
    return authors_.size();
  }
  /**
   * <code>repeated .author.Author authors = 1;</code>
   */
  @java.lang.Override
  public sr.grpc.gen.Author getAuthors(int index) {
    return authors_.get(index);
  }
  /**
   * <code>repeated .author.Author authors = 1;</code>
   */
  @java.lang.Override
  public sr.grpc.gen.AuthorOrBuilder getAuthorsOrBuilder(
      int index) {
    return authors_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < authors_.size(); i++) {
      output.writeMessage(1, authors_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < authors_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, authors_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sr.grpc.gen.Authors)) {
      return super.equals(obj);
    }
    sr.grpc.gen.Authors other = (sr.grpc.gen.Authors) obj;

    if (!getAuthorsList()
        .equals(other.getAuthorsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAuthorsCount() > 0) {
      hash = (37 * hash) + AUTHORS_FIELD_NUMBER;
      hash = (53 * hash) + getAuthorsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.Authors parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Authors parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Authors parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Authors parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Authors parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Authors parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Authors parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Authors parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.Authors parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Authors parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.Authors parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Authors parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sr.grpc.gen.Authors prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code author.Authors}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:author.Authors)
      sr.grpc.gen.AuthorsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.AuthorProto.internal_static_author_Authors_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.AuthorProto.internal_static_author_Authors_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.Authors.class, sr.grpc.gen.Authors.Builder.class);
    }

    // Construct using sr.grpc.gen.Authors.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getAuthorsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (authorsBuilder_ == null) {
        authors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        authorsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.AuthorProto.internal_static_author_Authors_descriptor;
    }

    @java.lang.Override
    public sr.grpc.gen.Authors getDefaultInstanceForType() {
      return sr.grpc.gen.Authors.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.gen.Authors build() {
      sr.grpc.gen.Authors result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.gen.Authors buildPartial() {
      sr.grpc.gen.Authors result = new sr.grpc.gen.Authors(this);
      int from_bitField0_ = bitField0_;
      if (authorsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          authors_ = java.util.Collections.unmodifiableList(authors_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.authors_ = authors_;
      } else {
        result.authors_ = authorsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.Authors) {
        return mergeFrom((sr.grpc.gen.Authors)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.Authors other) {
      if (other == sr.grpc.gen.Authors.getDefaultInstance()) return this;
      if (authorsBuilder_ == null) {
        if (!other.authors_.isEmpty()) {
          if (authors_.isEmpty()) {
            authors_ = other.authors_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureAuthorsIsMutable();
            authors_.addAll(other.authors_);
          }
          onChanged();
        }
      } else {
        if (!other.authors_.isEmpty()) {
          if (authorsBuilder_.isEmpty()) {
            authorsBuilder_.dispose();
            authorsBuilder_ = null;
            authors_ = other.authors_;
            bitField0_ = (bitField0_ & ~0x00000001);
            authorsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getAuthorsFieldBuilder() : null;
          } else {
            authorsBuilder_.addAllMessages(other.authors_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      sr.grpc.gen.Authors parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (sr.grpc.gen.Authors) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<sr.grpc.gen.Author> authors_ =
      java.util.Collections.emptyList();
    private void ensureAuthorsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        authors_ = new java.util.ArrayList<sr.grpc.gen.Author>(authors_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        sr.grpc.gen.Author, sr.grpc.gen.Author.Builder, sr.grpc.gen.AuthorOrBuilder> authorsBuilder_;

    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public java.util.List<sr.grpc.gen.Author> getAuthorsList() {
      if (authorsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(authors_);
      } else {
        return authorsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public int getAuthorsCount() {
      if (authorsBuilder_ == null) {
        return authors_.size();
      } else {
        return authorsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public sr.grpc.gen.Author getAuthors(int index) {
      if (authorsBuilder_ == null) {
        return authors_.get(index);
      } else {
        return authorsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder setAuthors(
        int index, sr.grpc.gen.Author value) {
      if (authorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAuthorsIsMutable();
        authors_.set(index, value);
        onChanged();
      } else {
        authorsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder setAuthors(
        int index, sr.grpc.gen.Author.Builder builderForValue) {
      if (authorsBuilder_ == null) {
        ensureAuthorsIsMutable();
        authors_.set(index, builderForValue.build());
        onChanged();
      } else {
        authorsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder addAuthors(sr.grpc.gen.Author value) {
      if (authorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAuthorsIsMutable();
        authors_.add(value);
        onChanged();
      } else {
        authorsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder addAuthors(
        int index, sr.grpc.gen.Author value) {
      if (authorsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAuthorsIsMutable();
        authors_.add(index, value);
        onChanged();
      } else {
        authorsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder addAuthors(
        sr.grpc.gen.Author.Builder builderForValue) {
      if (authorsBuilder_ == null) {
        ensureAuthorsIsMutable();
        authors_.add(builderForValue.build());
        onChanged();
      } else {
        authorsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder addAuthors(
        int index, sr.grpc.gen.Author.Builder builderForValue) {
      if (authorsBuilder_ == null) {
        ensureAuthorsIsMutable();
        authors_.add(index, builderForValue.build());
        onChanged();
      } else {
        authorsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder addAllAuthors(
        java.lang.Iterable<? extends sr.grpc.gen.Author> values) {
      if (authorsBuilder_ == null) {
        ensureAuthorsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, authors_);
        onChanged();
      } else {
        authorsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder clearAuthors() {
      if (authorsBuilder_ == null) {
        authors_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        authorsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public Builder removeAuthors(int index) {
      if (authorsBuilder_ == null) {
        ensureAuthorsIsMutable();
        authors_.remove(index);
        onChanged();
      } else {
        authorsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public sr.grpc.gen.Author.Builder getAuthorsBuilder(
        int index) {
      return getAuthorsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public sr.grpc.gen.AuthorOrBuilder getAuthorsOrBuilder(
        int index) {
      if (authorsBuilder_ == null) {
        return authors_.get(index);  } else {
        return authorsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public java.util.List<? extends sr.grpc.gen.AuthorOrBuilder> 
         getAuthorsOrBuilderList() {
      if (authorsBuilder_ != null) {
        return authorsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(authors_);
      }
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public sr.grpc.gen.Author.Builder addAuthorsBuilder() {
      return getAuthorsFieldBuilder().addBuilder(
          sr.grpc.gen.Author.getDefaultInstance());
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public sr.grpc.gen.Author.Builder addAuthorsBuilder(
        int index) {
      return getAuthorsFieldBuilder().addBuilder(
          index, sr.grpc.gen.Author.getDefaultInstance());
    }
    /**
     * <code>repeated .author.Author authors = 1;</code>
     */
    public java.util.List<sr.grpc.gen.Author.Builder> 
         getAuthorsBuilderList() {
      return getAuthorsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        sr.grpc.gen.Author, sr.grpc.gen.Author.Builder, sr.grpc.gen.AuthorOrBuilder> 
        getAuthorsFieldBuilder() {
      if (authorsBuilder_ == null) {
        authorsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            sr.grpc.gen.Author, sr.grpc.gen.Author.Builder, sr.grpc.gen.AuthorOrBuilder>(
                authors_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        authors_ = null;
      }
      return authorsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:author.Authors)
  }

  // @@protoc_insertion_point(class_scope:author.Authors)
  private static final sr.grpc.gen.Authors DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.Authors();
  }

  public static sr.grpc.gen.Authors getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Authors>
      PARSER = new com.google.protobuf.AbstractParser<Authors>() {
    @java.lang.Override
    public Authors parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Authors(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Authors> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Authors> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.gen.Authors getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
