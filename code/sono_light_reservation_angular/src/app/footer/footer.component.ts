import { Component } from '@angular/core';
import { SocialLinks } from '../shared/UTILS/socialLinks';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {
  // Get the year used for copyright
  date = new Date().getFullYear();
  // creer un tableau pour inserser les lien des réseaux sociaux cde KLS
  socialLinks: SocialLinks[];
  constructor() {
    this.socialLinks = [];
  }
  ngOnInit(): void {
    this.socialLinks.push(
      new SocialLinks(
        'facebook link',
        'https//www.facebook.com',
        'facebook.png'
      ),
      new SocialLinks('Discord link', 'https//discord.com', 'discord.png'),
      new SocialLinks('Youtube link', 'https//www.youtube.com', 'youtube.png'),
      new SocialLinks('Tik tok link', 'https//www.tiktok.com', 'tiktok.png'),
      new SocialLinks(
        'Instagram link',
        'https//www.instagram.com',
        'insta.png'
      ),
      new SocialLinks('Twitch link', 'https//www.twitch.tv', 'twitch.png'),
      new SocialLinks('Twitter link', 'https//www.twitter.com', 'twitter.png'),
      new SocialLinks(
        'Linkedin link',
        'https//www.linkedin.com',
        'linkedin.png'
      )
    );
  }
}
