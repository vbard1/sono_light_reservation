export interface Category {
    categoryId: number;
    label: string;
    description: string;
    picture_link: string;
    sectionId: number;
    isCollapsed:boolean; // front purposes only
}  