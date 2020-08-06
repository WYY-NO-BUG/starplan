package com.demo.starplan.bean;

import java.util.List;

public class BabyBusBean {

    /**
     * ResultCode : 0
     * ResultMessage : 调用成功
     * Data : {"RecommendList":[{"Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20181031/7ddda9376a0c402485eaad18e8da856f.jpg","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2},{"Img":"http://pic-manage.babybus.com/Public/Uploads/song/2018-01-25/752bde05-8a91-4317-878b-cbefaccb591e.jpg?w=500&h=276","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2},{"Img":"http://pic-manage.babybus.com/Public/Uploads/song/2018-01-25/752bde05-8a91-4317-878b-cbefaccb591e.jpg?w=500&h=276","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2}],"RecentlyPlay":{"TopicID":29,"Img":"https://pic-papp.babybus.com/Public/Uploads/song/2017-12-06/111278fa-c562-4efd-a687-bdb699eaadc1.png?w=620&h=388","ImgType":1},"SubjectList":[{"Name":"吃饭","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"哄睡","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"奇妙课堂","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"绘本故事","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"VIP会员","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119}],"EliteList":[{"Name":"儿歌精选","Img":"https://pic-papp.babybus.com/Public/Uploads/song/2019-01-30/29a5410b-9630-4d47-9337-c1f3a9be270a.png?w=304&h=66","ImgType":1,"HasMore":1,"ColumnID":13,"List":[{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"流行童谣","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"蜜蜜一家","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"疯狂怪兽车","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0}]}]}
     */

    private String ResultCode;
    private String ResultMessage;
    private DataBean Data;

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String ResultCode) {
        this.ResultCode = ResultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String ResultMessage) {
        this.ResultMessage = ResultMessage;
}

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * RecommendList : [{"Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20181031/7ddda9376a0c402485eaad18e8da856f.jpg","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2},{"Img":"http://pic-manage.babybus.com/Public/Uploads/song/2018-01-25/752bde05-8a91-4317-878b-cbefaccb591e.jpg?w=500&h=276","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2},{"Img":"http://pic-manage.babybus.com/Public/Uploads/song/2018-01-25/752bde05-8a91-4317-878b-cbefaccb591e.jpg?w=500&h=276","ImgType":1,"TopicID":108,"SerialInfo":"","IsShowSerialInfo":0,"Flag":2}]
         * RecentlyPlay : {"TopicID":29,"Img":"https://pic-papp.babybus.com/Public/Uploads/song/2017-12-06/111278fa-c562-4efd-a687-bdb699eaadc1.png?w=620&h=388","ImgType":1}
         * SubjectList : [{"Name":"吃饭","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"哄睡","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"奇妙课堂","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"绘本故事","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119},{"Name":"VIP会员","Img":"https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180","ImgType":1,"TopicID":119}]
         * EliteList : [{"Name":"儿歌精选","Img":"https://pic-papp.babybus.com/Public/Uploads/song/2019-01-30/29a5410b-9630-4d47-9337-c1f3a9be270a.png?w=304&h=66","ImgType":1,"HasMore":1,"ColumnID":13,"List":[{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"流行童谣","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"蜜蜜一家","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"疯狂怪兽车","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0}]}]
         */

        private RecentlyPlayBean RecentlyPlay;
        private List<RecommendListBean> RecommendList;
        private List<SubjectListBean> SubjectList;
        private List<EliteListBean> EliteList;

        public RecentlyPlayBean getRecentlyPlay() {
            return RecentlyPlay;
        }

        public void setRecentlyPlay(RecentlyPlayBean RecentlyPlay) {
            this.RecentlyPlay = RecentlyPlay;
        }

        public List<RecommendListBean> getRecommendList() {
            return RecommendList;
        }

        public void setRecommendList(List<RecommendListBean> RecommendList) {
            this.RecommendList = RecommendList;
        }

        public List<SubjectListBean> getSubjectList() {
            return SubjectList;
        }

        public void setSubjectList(List<SubjectListBean> SubjectList) {
            this.SubjectList = SubjectList;
        }

        public List<EliteListBean> getEliteList() {
            return EliteList;
        }

        public void setEliteList(List<EliteListBean> EliteList) {
            this.EliteList = EliteList;
        }

        public static class RecentlyPlayBean {
            /**
             * TopicID : 29
             * Img : https://pic-papp.babybus.com/Public/Uploads/song/2017-12-06/111278fa-c562-4efd-a687-bdb699eaadc1.png?w=620&h=388
             * ImgType : 1
             */

            private int TopicID;
            private String Img;
            private int ImgType;

            public int getTopicID() {
                return TopicID;
            }

            public void setTopicID(int TopicID) {
                this.TopicID = TopicID;
            }

            public String getImg() {
                return Img;
            }

            public void setImg(String Img) {
                this.Img = Img;
            }

            public int getImgType() {
                return ImgType;
            }

            public void setImgType(int ImgType) {
                this.ImgType = ImgType;
            }
        }

        public static class RecommendListBean {
            /**
             * Img : https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20181031/7ddda9376a0c402485eaad18e8da856f.jpg
             * ImgType : 1
             * TopicID : 108
             * SerialInfo :
             * IsShowSerialInfo : 0
             * Flag : 2
             */

            private String Img;
            private int ImgType;
            private int TopicID;
            private String SerialInfo;
            private int IsShowSerialInfo;
            private int Flag;
            private int type = 1;

            public String getImg() {
                return Img;
            }

            public void setImg(String Img) {
                this.Img = Img;
            }

            public int getImgType() {
                return ImgType;
            }

            public void setImgType(int ImgType) {
                this.ImgType = ImgType;
            }

            public int getTopicID() {
                return TopicID;
            }

            public void setTopicID(int TopicID) {
                this.TopicID = TopicID;
            }

            public String getSerialInfo() {
                return SerialInfo;
            }

            public void setSerialInfo(String SerialInfo) {
                this.SerialInfo = SerialInfo;
            }

            public int getIsShowSerialInfo() {
                return IsShowSerialInfo;
            }

            public void setIsShowSerialInfo(int IsShowSerialInfo) {
                this.IsShowSerialInfo = IsShowSerialInfo;
            }

            public int getFlag() {
                return Flag;
            }

            public void setFlag(int Flag) {
                this.Flag = Flag;
            }
        }

        public static class SubjectListBean {
            /**
             * Name : 吃饭
             * Img : https://picfile-baidu.babybus.com/song/img/20190830/436777ab9d984916ac08634c4ac6c817.png?w=180&h=180
             * ImgType : 1
             * TopicID : 119
             */

            private String Name;
            private String Img;
            private int ImgType;
            private int TopicID;
            private int type = 2;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getImg() {
                return Img;
            }

            public void setImg(String Img) {
                this.Img = Img;
            }

            public int getImgType() {
                return ImgType;
            }

            public void setImgType(int ImgType) {
                this.ImgType = ImgType;
            }

            public int getTopicID() {
                return TopicID;
            }

            public void setTopicID(int TopicID) {
                this.TopicID = TopicID;
            }
        }

        public static class EliteListBean {
            /**
             * Name : 儿歌精选
             * Img : https://pic-papp.babybus.com/Public/Uploads/song/2019-01-30/29a5410b-9630-4d47-9337-c1f3a9be270a.png?w=304&h=66
             * ImgType : 1
             * HasMore : 1
             * ColumnID : 13
             * List : [{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"流行童谣","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"蜜蜜一家","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"疯狂怪兽车","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0},{"ID":57,"Name":"经典儿歌100首","Img":"https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388","ImgType":1,"Desc":"耳熟能详的儿童金曲","Type":1,"No":1,"MediaID":0,"SerialInfo":"","IsShowSerialInfo":0,"Flag":0}]
             */

            private String Name;
            private String Img;
            private int ImgType;
            private int HasMore;
            private int ColumnID;
            private java.util.List<ListBean> List;
            private int type = 3;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getImg() {
                return Img;
            }

            public void setImg(String Img) {
                this.Img = Img;
            }

            public int getImgType() {
                return ImgType;
            }

            public void setImgType(int ImgType) {
                this.ImgType = ImgType;
            }

            public int getHasMore() {
                return HasMore;
            }

            public void setHasMore(int HasMore) {
                this.HasMore = HasMore;
            }

            public int getColumnID() {
                return ColumnID;
            }

            public void setColumnID(int ColumnID) {
                this.ColumnID = ColumnID;
            }

            public List<ListBean> getList() {
                return List;
            }

            public void setList(List<ListBean> List) {
                this.List = List;
            }

            public static class ListBean {
                /**
                 * ID : 57
                 * Name : 经典儿歌100首
                 * Img : https://picfile-baidu.babybus.com/song/img/20190514/62041982cac04942a9cc3ce1312b7b60.png?w=620&h=388
                 * ImgType : 1
                 * Desc : 耳熟能详的儿童金曲
                 * Type : 1
                 * No : 1
                 * MediaID : 0
                 * SerialInfo :
                 * IsShowSerialInfo : 0
                 * Flag : 0
                 */

                private int ID;
                private String Name;
                private String Img;
                private int ImgType;
                private String Desc;
                private int Type;
                private int No;
                private int MediaID;
                private String SerialInfo;
                private int IsShowSerialInfo;
                private int Flag;
                private int type = 4;

                public int getBackType(){
                    return type;
                }

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public String getImg() {
                    return Img;
                }

                public void setImg(String Img) {
                    this.Img = Img;
                }

                public int getImgType() {
                    return ImgType;
                }

                public void setImgType(int ImgType) {
                    this.ImgType = ImgType;
                }

                public String getDesc() {
                    return Desc;
                }

                public void setDesc(String Desc) {
                    this.Desc = Desc;
                }

                public int getType() {
                    return Type;
                }

                public void setType(int Type) {
                    this.Type = Type;
                }

                public int getNo() {
                    return No;
                }

                public void setNo(int No) {
                    this.No = No;
                }

                public int getMediaID() {
                    return MediaID;
                }

                public void setMediaID(int MediaID) {
                    this.MediaID = MediaID;
                }

                public String getSerialInfo() {
                    return SerialInfo;
                }

                public void setSerialInfo(String SerialInfo) {
                    this.SerialInfo = SerialInfo;
                }

                public int getIsShowSerialInfo() {
                    return IsShowSerialInfo;
                }

                public void setIsShowSerialInfo(int IsShowSerialInfo) {
                    this.IsShowSerialInfo = IsShowSerialInfo;
                }

                public int getFlag() {
                    return Flag;
                }

                public void setFlag(int Flag) {
                    this.Flag = Flag;
                }
            }
        }
    }
}
