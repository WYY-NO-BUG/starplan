package com.demo.starplan.bean;

import java.util.List;

public class VideoBean {
    /**
     * ResultCode : 0
     * ResultMessage : 调用成功
     * Data : {"Name":"经典儿歌100首","Info":"宝宝最爱曲曲经典","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20200616/97b356dce67d441b910cac23584f6efe.jpg","ImgType":1,"MediaCount":100,"list":[{"ID":283,"No":1,"Name":"两只老虎","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20200616/3ad6b6b50bd14648bc637d63be30c7fe.jpg","MediaType":1,"PlayLen":"74","VideoUrl":"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"},{"ID":177,"No":3,"Name":"小兔子乖乖","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/2ab31c4e41d943da96c67df7705159f6.jpg","MediaType":1,"PlayLen":"92","VideoUrl":"http://vjs.zencdn.net/v/oceans.mp4"},{"ID":133,"No":4,"Name":"工程车","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/c53711b4842e4edc9529a1232324f62f.jpg","MediaType":1,"PlayLen":"110","VideoUrl":"https://media.w3.org/2010/05/sintel/trailer.mp4"},{"ID":637,"No":5,"Name":"小毛驴","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/d030f95ac8da446ca6a11d2fa69c87bd.jpg","MediaType":1,"PlayLen":"86","VideoUrl":"http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4"}]}
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
         * Name : 经典儿歌100首
         * Info : 宝宝最爱曲曲经典
         * Img : https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20200616/97b356dce67d441b910cac23584f6efe.jpg
         * ImgType : 1
         * MediaCount : 100
         * list : [{"ID":283,"No":1,"Name":"两只老虎","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20200616/3ad6b6b50bd14648bc637d63be30c7fe.jpg","MediaType":1,"PlayLen":"74","VideoUrl":"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"},{"ID":177,"No":3,"Name":"小兔子乖乖","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/2ab31c4e41d943da96c67df7705159f6.jpg","MediaType":1,"PlayLen":"92","VideoUrl":"http://vjs.zencdn.net/v/oceans.mp4"},{"ID":133,"No":4,"Name":"工程车","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/c53711b4842e4edc9529a1232324f62f.jpg","MediaType":1,"PlayLen":"110","VideoUrl":"https://media.w3.org/2010/05/sintel/trailer.mp4"},{"ID":637,"No":5,"Name":"小毛驴","Img":"https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20190505/d030f95ac8da446ca6a11d2fa69c87bd.jpg","MediaType":1,"PlayLen":"86","VideoUrl":"http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4"}]
         */

        private String Name;
        private String Info;
        private String Img;
        private int ImgType;
        private int MediaCount;
        private List<ListBean> list;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getInfo() {
            return Info;
        }

        public void setInfo(String Info) {
            this.Info = Info;
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

        public int getMediaCount() {
            return MediaCount;
        }

        public void setMediaCount(int MediaCount) {
            this.MediaCount = MediaCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ID : 283
             * No : 1
             * Name : 两只老虎
             * Img : https://videopic-baidu.kidvideo.cn/BabyVideo/VideoPic/20200616/3ad6b6b50bd14648bc637d63be30c7fe.jpg
             * MediaType : 1
             * PlayLen : 74
             * VideoUrl : http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
             */

            private int ID;
            private int No;
            private String Name;
            private String Img;
            private int MediaType;
            private String PlayLen;
            private String VideoUrl;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getNo() {
                return No;
            }

            public void setNo(int No) {
                this.No = No;
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

            public int getMediaType() {
                return MediaType;
            }

            public void setMediaType(int MediaType) {
                this.MediaType = MediaType;
            }

            public String getPlayLen() {
                return PlayLen;
            }

            public void setPlayLen(String PlayLen) {
                this.PlayLen = PlayLen;
            }

            public String getVideoUrl() {
                return VideoUrl;
            }

            public void setVideoUrl(String VideoUrl) {
                this.VideoUrl = VideoUrl;
            }
        }
    }
}
